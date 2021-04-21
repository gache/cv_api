package fr.erickfranco.cv_api.controllers;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProjetController {

//    @Autowired
//    private final ProjetServiceInter projetServiceInter;
//
//    public ProjetController(ProjetServiceInter projetServiceInter) {
//        this.projetServiceInter = projetServiceInter;
//    }
//
//    @GetMapping("/projets")
//    public ResponseEntity<List<Projet>> getProjets() {
//        return ResponseEntity.status(HttpStatus.OK).body(projetServiceInter.findAllProjet());
//    }
//
//    @PostMapping("/createProjet")
//    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(projetServiceInter.saveProjet(projet));
//    }
//
//    @GetMapping("projetsId/{id}")
//    public ResponseEntity<Projet> ProjetById(@PathVariable Integer id) {
//        return ResponseEntity.status(HttpStatus.OK).body(projetServiceInter.findProjetById(id));
//    }
//
//    @PutMapping("/updateProjet")
//    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet) {
//        return ResponseEntity.status(HttpStatus.OK).body(projetServiceInter.saveProjet(projet));
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Projet> deleteProjet(@PathVariable("id") Integer id) {
//        projetServiceInter.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}
