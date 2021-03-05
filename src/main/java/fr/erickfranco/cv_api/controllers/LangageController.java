package fr.erickfranco.cv_api.controllers;


import fr.erickfranco.cv_api.models.Langage;
import fr.erickfranco.cv_api.services.LangageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
@RestController
public class LangageController {

    @Autowired
    private LangageService langageService;

    @GetMapping("/langages")
    public ResponseEntity<List<Langage>> getLangage() {
        return ResponseEntity.status(HttpStatus.OK).body(langageService.findAllLangage());
    }

    @PostMapping("/createLangage")
    public ResponseEntity<Langage> createLangage(@RequestBody Langage langage) {
        return ResponseEntity.status(HttpStatus.CREATED).body(langageService.createLangage(langage));
    }

    @GetMapping("/langageId/{id}")
    public ResponseEntity<Langage> getLangageById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(langageService.findLangageById(id));
    }


    @PutMapping("/updateLangage")
    public ResponseEntity<Langage> updateLangage(@RequestBody Langage langage) {
        return ResponseEntity.status(HttpStatus.CREATED).body(langageService.createLangage(langage));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Langage> deleteLangage(@PathVariable("id") Integer id) {
        langageService.deleteLangageById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
