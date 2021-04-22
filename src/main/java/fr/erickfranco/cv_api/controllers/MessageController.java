package fr.erickfranco.cv_api.controllers;


import fr.erickfranco.cv_api.models.Message;
import fr.erickfranco.cv_api.services.serviceinter.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private final IMessageService iMessageService;

    public MessageController(IMessageService iMessageService) {
        this.iMessageService = iMessageService;
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok().body(iMessageService.findAll());
    }

    // recherche d'une message par Id
    @GetMapping("/messages/{id}")
    public ResponseEntity<?> getId(@PathVariable Long id) {
        Message message = null;
        Map<String, Object> response = new HashMap<String, Object>();
        try {
            message = iMessageService.findById(id);
        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de faire une consultation à la base de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (message == null) {
            response.put("message", "Le message Id: ".concat(id.toString().concat(" n'existe pas dans la base de données!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Message>(message, HttpStatus.OK);
    }


    @PostMapping("/messages")
    public ResponseEntity<?> create(@Valid @RequestBody Message messageP, BindingResult result) {
        Message newMessage = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "Le champ: ' " + err.getField() + " '. " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("errors", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            newMessage = iMessageService.save(messageP);
        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de la création d'une nouveau message dans la base de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Le message a été creer avec satisfaction");
        response.put("messageJSON", newMessage);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }


    @PutMapping("/messages/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Message message, BindingResult result, @PathVariable Long id) {
        Message messageActuelle = iMessageService.findById(id);
        Message updateMessage = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors()) {

            List<String> errors = result.getFieldErrors().stream()
                    .map(err -> "Le Champ '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("erreurs", errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (messageActuelle == null) {
            response.put("message", "Erreur: au moment de l'edition du message Id: "
                    .concat(id.toString().concat(" n'existe pas dans la base de données!")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            messageActuelle.setEmail(message.getEmail());
            messageActuelle.setNom(message.getNom());
            messageActuelle.setPrenom(message.getPrenom());
            messageActuelle.setSujet(message.getSujet());
            messageActuelle.setMessage(message.getMessage());
            messageActuelle.setDate(message.getDate());

            updateMessage = iMessageService.save(messageActuelle);

        } catch (DataAccessException e) {
            response.put("message", "Erreur au moment de la actualisation du message dans la bases de données");
            response.put("error", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("message", "Le message a été actualiser correctement");
        response.put("messageJSON", updateMessage);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<String, Object>();

        try {
            iMessageService.delete(id);
        } catch (DataAccessException e) {
            response.put("message", "Erreur  au moment de l'elimination du message dans la bases de données");
            response.put("erreur", e.getMessage().concat(": ".concat(e.getMostSpecificCause().getMessage())));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("message", "Le message a été eliminer avec satisfaction");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

    }


}
