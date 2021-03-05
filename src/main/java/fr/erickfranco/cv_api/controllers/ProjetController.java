package fr.erickfranco.cv_api.controllers;


import fr.erickfranco.cv_api.models.Projet;
import fr.erickfranco.cv_api.services.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjetController {

    @Autowired
    private ProjetService projetService;

    @GetMapping("/projets")
    public ResponseEntity<List<Projet>> getProjets() {
        return ResponseEntity.status(HttpStatus.OK).body(projetService.findAllProjet());
    }

    @PostMapping("/projets/createProjet")
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projetService.createProjet(projet));
    }

    @GetMapping("projetsId/{id}")
    public ResponseEntity<Projet> ProjetById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(projetService.findProjetById(id));
    }

    @PutMapping("/updateProjet")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet) {
        return ResponseEntity.status(HttpStatus.OK).body(projetService.createProjet(projet));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Projet> deleteProjet(@PathVariable("id") Integer id) {
        projetService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
