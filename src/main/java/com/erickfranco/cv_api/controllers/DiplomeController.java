package com.erickfranco.cv_api.controllers;


import com.erickfranco.cv_api.models.Diplome;
import com.erickfranco.cv_api.services.DiplomeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/diplomes")
public class DiplomeController {

    @Autowired
    public DiplomeServiceImpl diplomeService;

    @GetMapping("/diplomes")
    public ResponseEntity<List<Diplome>> getDiplomes() {
        try {
            return new ResponseEntity<>(diplomeService.findAllDiplome(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Diplome>> getDiplomeById(@PathVariable("id") Integer id) {
        try {
            return new ResponseEntity<>(diplomeService.findDiplomeById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Diplome> createDiplome(@RequestBody Diplome diplome) {
        try {
            return new ResponseEntity<>(diplomeService.createDiplome(diplome), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Diplome> updateDiplome(@RequestBody Diplome diplome) {
        try {
            return new ResponseEntity<>(diplomeService.createDiplome(diplome), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        diplomeService.deleteDiplomeById(id);
        return "Diplome eliminer";
    }

}



