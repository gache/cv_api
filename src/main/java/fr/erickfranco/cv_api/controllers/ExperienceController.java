package fr.erickfranco.cv_api.controllers;

import fr.erickfranco.cv_api.models.Experience;
import fr.erickfranco.cv_api.services.serviceinter.IExpericenceService;
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
@RestController
@RequestMapping("/api")
public class ExperienceController {

    @Autowired
    private final IExpericenceService iExpericenceService;


    public ExperienceController(IExpericenceService iExpericenceService) {
        this.iExpericenceService = iExpericenceService;
    }

    @GetMapping("/experiences")
    public ResponseEntity<List<Experience>> getExperiences() {
        return ResponseEntity.ok().body(iExpericenceService.findAll());
    }

    // recherche d'une experience par Id
    @GetMapping("/experiences/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id) {
        Experience experience = null;
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            experience = iExpericenceService.findById(id);
        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de faire une consultation à la base de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (experience == null) {
            response.put("message", "L'experience Id: ".concat(id.toString().concat(" n'existe pas dans la base de données!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Experience>(experience, HttpStatus.OK);
    }

    @PostMapping("/experiences")
    public ResponseEntity<?> create(@Valid @RequestBody Experience experience, BindingResult result) {
        Experience newExperience = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "Le champ '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            newExperience = iExpericenceService.save(experience);
        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de la création d'une nouvelle experience dans la base de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "L'experience a été creer avec satisfaction");
        response.put("experience", newExperience);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/experiences/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Experience experience, BindingResult result, @PathVariable Long id) {
        Experience experienceActuelle = iExpericenceService.findById(id);
        Experience updateExperience = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "Le Champ '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (experienceActuelle == null) {
            response.put("message", "Erreur: au moment de l'edition de l'experience Id: "
                    .concat(id.toString().concat(" n'existe pas dans la base de données!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            experienceActuelle.setTitrePoste(experience.getTitrePoste());
            experienceActuelle.setEntreprise(experience.getEntreprise());
            experienceActuelle.setDescription(experience.getDescription());
            experienceActuelle.setVille(experience.getVille());
            experienceActuelle.setDate(experience.getDate());

            updateExperience = iExpericenceService.save(experienceActuelle);
        } catch (DataAccessException e) {
            response.put("message", "Erreurr au moment de la actualisation d'experience dans la bases de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "L'experience a été actualiser correctement");
        response.put("experience", updateExperience);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/experiences/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<String, Object>();

        try {
            Experience experience = iExpericenceService.findById(id);
            iExpericenceService.delete(id);
        } catch (DataAccessException e) {
            response.put("message", "Erreur  au moment de l'elimination de l'experience dans la bases de données");
            response.put("erreur", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "L'experience a été eliminer avec satisfaction");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


}



