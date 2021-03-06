package fr.erickfranco.cv_api.controllers;


import fr.erickfranco.cv_api.models.Diplome;
import fr.erickfranco.cv_api.services.serviceinter.DiplomeServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DiplomeController {

    @Autowired
    public final DiplomeServiceInter diplomeServiceInter;

    public DiplomeController(DiplomeServiceInter diplomeServiceInter) {
        this.diplomeServiceInter = diplomeServiceInter;
    }

    @GetMapping("/diplomes")
    public ResponseEntity<List<Diplome>> getDiplomes() {
        return ResponseEntity.status(HttpStatus.OK).body(diplomeServiceInter.findAllDiplome());
    }

    @GetMapping("/diplomeId/{id}")
    public ResponseEntity<Diplome> getDiplomeById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(diplomeServiceInter.findDiplomeById(id));
    }

    @PostMapping("/createDiplome")
    public ResponseEntity<Diplome> createDiplome(@RequestBody Diplome diplome) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diplomeServiceInter.saveDiplome(diplome));
    }

    @PutMapping("/updateDiplome")
    public ResponseEntity<Diplome> updateDiplome(@RequestBody Diplome diplome) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diplomeServiceInter.saveDiplome(diplome));
    }

    @DeleteMapping("/deleteDiplomeId/{id}")
    public ResponseEntity<Diplome> delete(@PathVariable("id") Integer id) {
        diplomeServiceInter.deleteDiplomeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



