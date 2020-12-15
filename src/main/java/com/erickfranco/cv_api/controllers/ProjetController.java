package com.erickfranco.cv_api.controllers;

import com.erickfranco.cv_api.models.Projet;
import com.erickfranco.cv_api.services.ProjetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ProjetController {

    @Autowired
    private ProjetServiceImpl projetService;


    @GetMapping("/projets")
    public ResponseEntity<List<Projet>> getProjets() {
        try {
            return new ResponseEntity<>(projetService.findAllProjet(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/projets/createProjet")
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        try {
            return new ResponseEntity<>(projetService.createProjet(projet), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/projets/projetsId/{id}")
    public ResponseEntity<Optional<Projet>> getProjetById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(projetService.findProjetById(id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/projets/updateProjet")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet) {
        try {
            return new ResponseEntity<>(projetService.createProjet(projet), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/projets/deleteProjetId/{id}")
    public String deleteProjet(@PathVariable Integer id) {
        projetService.deleteProjetById(id);
        return "Projet Eliminé";
    }


}
