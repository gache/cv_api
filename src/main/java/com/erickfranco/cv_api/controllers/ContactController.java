package com.erickfranco.cv_api.controllers;


import com.erickfranco.cv_api.models.Contact;
import com.erickfranco.cv_api.services.ContactServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
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

    @PostMapping("/contacts/createContact")
    public void addContact(@RequestBody Contact contact) throws IOException {
        contactService.save(contact);
    }

    @GetMapping("/contacts/contactId/{id}")
    public ResponseEntity<Optional<Contact>> getProjetById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(contactService.findMessageById(id), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/contacts/deleteContactId/{id}")
    public String deleteProjet(@PathVariable Integer id) {
        contactService.deleteMessageById(id);
        return "Contact Eliminé";
    }

}
