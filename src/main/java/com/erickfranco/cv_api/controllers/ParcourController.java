package com.erickfranco.cv_api.controllers;

import com.erickfranco.cv_api.models.Parcour;
import com.erickfranco.cv_api.services.ParcourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class ParcourController {

    @Autowired
    public ParcourServiceImpl parcourService;

    @GetMapping("/parcour")
    public ResponseEntity<List<Parcour>> getDiplome() {
        try {
            return new ResponseEntity<>(parcourService.findAll(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/parcour/createParcour")
    public ResponseEntity<Parcour> saveDiplome(@RequestBody Parcour parcour) {
        try {
            return new ResponseEntity<>(parcourService.save(parcour), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/parcour/parcourId/{id}")
    public ResponseEntity<Optional<Parcour>> getDiplomeById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(parcourService.findById(id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/parcour/updateParcour")
    public ResponseEntity<Parcour> updateParcour(@RequestBody Parcour parcour) {
        try {
            return new ResponseEntity<>(parcourService.save(parcour), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/parcour/deleteParcourId/{id}")
    public String deleteParcour(@PathVariable Integer id) {
        parcourService.deleteById(id);
        return "Parcour Eliminé";
    }
}



