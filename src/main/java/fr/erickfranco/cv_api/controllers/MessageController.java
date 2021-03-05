package fr.erickfranco.cv_api.controllers;


import fr.erickfranco.cv_api.models.Message;
import fr.erickfranco.cv_api.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getContact() {
        return ResponseEntity.status(HttpStatus.OK).body(messageService.findAllMessage());
    }

    @PostMapping("/messages/createMessage")
    public ResponseEntity<Message> addContact(@RequestBody Message message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.saveMessage(message));
    }

    @GetMapping("/messages/messageId/{id}")
    public ResponseEntity<Message> getProjetById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(messageService.findMessageById(id));
    }

    @DeleteMapping("/messages/deleteMessagesId/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable Integer id) {
        messageService.deleteMessageById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
