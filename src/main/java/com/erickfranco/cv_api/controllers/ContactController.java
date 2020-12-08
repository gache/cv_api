package com.erickfranco.cv_api.controllers;


import com.erickfranco.cv_api.models.Contact;
import com.erickfranco.cv_api.services.ContactServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ContactController {

    @Autowired
    private ContactServiceImple contactService;

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getContact() {
        try {
            return new ResponseEntity<>(contactService.findAllMessage(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/createContact")
    public ResponseEntity<Contact> createProjet(@RequestBody Contact contact) {
        try {
            return new ResponseEntity<>(contactService.createMessage(contact), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

   /* @GetMapping("/contact/{id}")
    public ResponseEntity<Optional<Contact>> getProjetById(@PathVariable String email) {
        try {
            return new ResponseEntity<>(contactService.deleteMessageById(email), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }*/


    @DeleteMapping("/deleteContact/{id}")
    public String deleteProjet(@PathVariable String id) {
        contactService.deleteMessageById(id);
        return "Projet Eliminé";
    }


}
