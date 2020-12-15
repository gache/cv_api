package com.erickfranco.cv_api.controllers;


import com.erickfranco.cv_api.models.Langage;
import com.erickfranco.cv_api.services.LangageServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class LangageController {

    @Autowired
    private LangageServiceImple langageService;

    @GetMapping("/langages")
    public ResponseEntity<List<Langage>> getLangage() {
        try {
            return new ResponseEntity<>(langageService.findAllLangage(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/langages/createLangage")
    public ResponseEntity<Langage> createLangage(@RequestBody Langage langage) {
        try {
            return new ResponseEntity<>(langageService.createLangage(langage), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/langages/langageId/{id}")
    public ResponseEntity<Optional<Langage>> getLangageById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(langageService.findLangageById(id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/langages/updateLangage")
    public ResponseEntity<Langage> updateLangage(@RequestBody Langage langage) {
        try {
            return new ResponseEntity<>(langageService.createLangage(langage), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/langages/deleteLangageId/{id}")

    public String deleteLangage(@PathVariable Integer id) {
        langageService.deleteLangageById(id);
        return "Langage Eliminé";
    }


}
