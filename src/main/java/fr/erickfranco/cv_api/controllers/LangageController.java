package fr.erickfranco.cv_api.controllers;


import fr.erickfranco.cv_api.models.Langage;
import fr.erickfranco.cv_api.services.serviceinter.ILangageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class LangageController {

    @Autowired
    private final ILangageService iLangageService;


    public LangageController(ILangageService iLangageService) {
        this.iLangageService = iLangageService;
    }

    @GetMapping("/langages")
    public ResponseEntity<List<Langage>> getLangages() {
        return ResponseEntity.ok().body(iLangageService.findAll());
    }

    // recherche d'une langage par Id
    @GetMapping("/langages/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id) {
        Langage langage = null;
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            langage = iLangageService.findById(id);
        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de faire une consultation à la base de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (langage == null) {
            response.put("message", "Le langage Id: ".concat(id.toString().concat(" n'existe pas dans la base de données!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Langage>(langage, HttpStatus.OK);
    }

    @PostMapping("/langages")
    public ResponseEntity<?> create(@Valid @RequestBody Langage langage, BindingResult result) {
        Langage newLangage = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "Le champ '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            newLangage = iLangageService.save(langage);
        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de la création d'une nouveau langage dans la base de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Le langage a été creer avec satisfaction");
        response.put("langage", newLangage);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/langages/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Langage langage, BindingResult result, @PathVariable Long id) {
        Langage langageActuelle = iLangageService.findById(id);
        Langage updateLangage = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "Le Champ '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("erreurs", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (langageActuelle == null) {
            response.put("message", "Erreur: au moment de l'edition du langage Id: "
                    .concat(id.toString().concat(" n'existe pas dans la base de données!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            langageActuelle.setLangageInformatique(langage.getLangageInformatique());
            langageActuelle.setPorcentage(langage.getPorcentage());
            updateLangage = iLangageService.save(langageActuelle);

        } catch (DataAccessException e) {
            response.put("message", "Erreurr au moment de la actualisation du langage dans la bases de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Le langage a été actualiser correctement");
        response.put("langage", updateLangage);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/langages/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<String, Object>();

        try {
            iLangageService.delete(id);
        } catch (DataAccessException e) {
            response.put("message", "Erreur  au moment de l'elimination de l'langage dans la bases de données");
            response.put("erreur", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "Le langage a été eliminer avec satisfaction");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


}
