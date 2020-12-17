package com.erickfranco.cv_api.controllers;


import com.erickfranco.cv_api.models.Diplome;
import com.erickfranco.cv_api.services.DiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DiplomeController {

    @Autowired
    public DiplomeService diplomeService;

    @GetMapping("/diplomes")
    public ResponseEntity<List<Diplome>> getDiplomes() {
        return ResponseEntity.status(HttpStatus.OK).body(diplomeService.findAllDiplome());
    }

    @GetMapping("/diplomeId/{id}")
    public ResponseEntity<Diplome> getDiplomeById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(diplomeService.findDiplomeById(id));
    }

    @PostMapping("/createDiplome")
    public ResponseEntity<Diplome> createDiplome(@RequestBody Diplome diplome) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diplomeService.createDiplome(diplome));
    }

    @PutMapping("/updateDiplome")
    public ResponseEntity<Diplome> updateDiplome(@RequestBody Diplome diplome) {
        return ResponseEntity.status(HttpStatus.CREATED).body(diplomeService.createDiplome(diplome));
    }

    @DeleteMapping("/deleteDiplomeId/{id}")
    public ResponseEntity<Diplome> delete(@PathVariable("id") Integer id) {
        diplomeService.deleteDiplomeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}



