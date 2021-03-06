package fr.erickfranco.cv_api.controllers;

import fr.erickfranco.cv_api.models.Experience;
import fr.erickfranco.cv_api.services.serviceinter.ExpericenceServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExperienceController {

    @Autowired
    public final ExpericenceServiceInter expericenceServiceInter;

    public ExperienceController(ExpericenceServiceInter expericenceServiceInter) {
        this.expericenceServiceInter = expericenceServiceInter;
    }

    @GetMapping("/experiences")
    public ResponseEntity<List<Experience>> getDiplome() {
        return ResponseEntity.status(HttpStatus.OK).body(expericenceServiceInter.findAll());
    }

    @PostMapping("/experiences/createExperience")
    public ResponseEntity<Experience> saveDiplome(@RequestBody Experience experience) {
       return ResponseEntity.status(HttpStatus.CREATED).body(expericenceServiceInter.saveExperience(experience));
    }

    @GetMapping("/experienceId/{id}")
    public ResponseEntity<Experience> experienceById(@PathVariable Integer id) {
       return ResponseEntity.status(HttpStatus.OK).body(expericenceServiceInter.findById(id));
    }

    @PutMapping("/updateExperience")
    public ResponseEntity<Experience> updateParcour(@RequestBody Experience experience) {
        return  ResponseEntity.status(HttpStatus.OK).body(expericenceServiceInter.saveExperience(experience));
    }

    @DeleteMapping("/deleteId/{id}")
    public ResponseEntity<Experience> deleteExperience(@PathVariable Integer id) {
       expericenceServiceInter.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



