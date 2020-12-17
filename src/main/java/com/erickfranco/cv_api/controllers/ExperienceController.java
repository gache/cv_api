package com.erickfranco.cv_api.controllers;

import com.erickfranco.cv_api.models.Experience;
import com.erickfranco.cv_api.services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExperienceController {

    @Autowired
    public ExperienceService experienceService;

    @GetMapping("/experiences")
    public ResponseEntity<List<Experience>> getDiplome() {
        return ResponseEntity.status(HttpStatus.OK).body(experienceService.findAll());
    }

    @PostMapping("/experiences/createExperience")
    public ResponseEntity<Experience> saveDiplome(@RequestBody Experience experience) {
       return ResponseEntity.status(HttpStatus.CREATED).body(experienceService.saveExperience(experience));
    }

    @GetMapping("/experienceId/{id}")
    public ResponseEntity<Experience> experienceById(@PathVariable Integer id) {
       return ResponseEntity.status(HttpStatus.OK).body(experienceService.findById(id));
    }

    @PutMapping("/updateExperience")
    public ResponseEntity<Experience> updateParcour(@RequestBody Experience experience) {
        return  ResponseEntity.status(HttpStatus.OK).body(experienceService.saveExperience(experience));
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Experience> deleteExperience(@PathVariable Integer id) {
       experienceService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



