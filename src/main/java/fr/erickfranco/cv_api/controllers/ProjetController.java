package fr.erickfranco.cv_api.controllers;


import fr.erickfranco.cv_api.models.Projet;
import fr.erickfranco.cv_api.services.serviceinter.IProjetService;
import fr.erickfranco.cv_api.services.serviceinter.IUploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ProjetController {

    @Autowired
    private final IProjetService iProjetService;

    @Autowired
    private final IUploadFileService iUploadFileService;


    public ProjetController(IProjetService iProjetService, IUploadFileService iUploadFileService) {
        this.iProjetService = iProjetService;
        this.iUploadFileService = iUploadFileService;
    }

    @GetMapping("/projets")
    public ResponseEntity<List<Projet>> getProjets() {
        return ResponseEntity.ok().body(iProjetService.findAll());
    }

    @GetMapping("/projets/page/{page}")
    public Page<Projet> index(@PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 3);
        return iProjetService.findAll(pageable);
    }


    // recherche d'une projet par Id
    @GetMapping("/projets/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id) {
        Projet projet = null;
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            projet = iProjetService.findById(id);
        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de faire une consultation à la base de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (projet == null) {
            response.put("message", "Le projet Id: ".concat(id.toString().concat(" n'existe pas dans la base de données!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Projet>(projet, HttpStatus.OK);
    }

    @PostMapping("/projets")
    public ResponseEntity<?> create(@Valid @RequestBody Projet projet, BindingResult result) {
        Projet newProjet = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "Le champ '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            newProjet = iProjetService.save(projet);
        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de la création d'une nouveau projet dans la base de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Le projet a été creer avec satisfaction");
        response.put("projet", newProjet);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/projets/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Projet projet, BindingResult result, @PathVariable Long id) {
        Projet projetActuelle = iProjetService.findById(id);
        Projet updateProjet = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "Le Champ '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("erreurs", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (projetActuelle == null) {
            response.put("message", "Erreur: au moment de l'edition du projet Id: "
                    .concat(id.toString().concat(" n'existe pas dans la base de données!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            projetActuelle.setNomProjet(projet.getNomProjet());
            projetActuelle.setDescriptionProjet(projet.getDescriptionProjet());
            projetActuelle.setLangageDuProjet(projet.getLangageDuProjet());
            projetActuelle.setUrlProjet(projet.getUrlProjet());
            updateProjet = iProjetService.save(projetActuelle);

        } catch (DataAccessException e) {
            response.put("message", "Erreurr au moment de la actualisation du projet dans la bases de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Le projet a été actualiser correctement");
        response.put("projet", updateProjet);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


    @DeleteMapping("/projets/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<String, Object>();

        try {
            Projet projet = iProjetService.findById(id);
            String nomPhotoAnterieur = projet.getPhoto();
            iUploadFileService.effacerPhoto(nomPhotoAnterieur);

            iProjetService.delete(id);
        } catch (DataAccessException e) {
            response.put("message", "Erreur  au moment de l'elimination du projet dans la bases de données");
            response.put("erreur", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "Le projet a été eliminer avec satisfaction");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @PostMapping("/projets/upload")
    public ResponseEntity<?> upload(@RequestParam("dossier") MultipartFile dossier, @RequestParam("id") Long id) {
        Map<String, Object> response = new HashMap<String, Object>();
        Projet projet = iProjetService.findById(id);
        if (!dossier.isEmpty()) {

            String nomDossier = null;

            try {
                nomDossier = iUploadFileService.enregistrerPhoto(dossier);
            } catch (IOException e) {
                response.put("message", "Erreur au moment de l'enregistrement de la photo ");
                response.put("erreur", e.getMessage().concat(": ".concat(e.getCause().getMessage())));
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            String nomPhotoAnterieur = projet.getPhoto();

            iUploadFileService.effacerPhoto(nomPhotoAnterieur);
            projet.setPhoto(nomDossier);
            iProjetService.save(projet);

            response.put("projet", projet);
            response.put("message", "L'image a été enregistrer correctement: " + nomDossier);

        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @GetMapping("/uploads/img/{nomPhoto:.+}")
    public ResponseEntity<Resource> voirPhoto(@PathVariable String nomPhoto) {
        Resource resource = null;

        try {
            resource = iUploadFileService.chargerPhoto(nomPhoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpHeaders tete = new HttpHeaders();
        tete.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");

        return new ResponseEntity<Resource>(resource, tete, HttpStatus.OK);
    }


}