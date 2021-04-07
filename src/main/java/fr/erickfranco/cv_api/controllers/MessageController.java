package fr.erickfranco.cv_api.controllers;


import fr.erickfranco.cv_api.models.Message;
import fr.erickfranco.cv_api.services.serviceinter.MessageServiceInter;
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
    private final MessageServiceInter messageServiceInter;

    public MessageController(MessageServiceInter messageServiceInter) {
        this.messageServiceInter = messageServiceInter;
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getContact() {
        return ResponseEntity.status(HttpStatus.OK).body(messageServiceInter.findAllMessage());
    }

    @PostMapping("/createMessage")
    public ResponseEntity<Message> addContact(@RequestBody Message message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageServiceInter.saveMessage(message));
    }

    @GetMapping("/messageId/{id}")
    public ResponseEntity<Message> getProjetById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(messageServiceInter.findMessageById(id));
    }

    @DeleteMapping("/deleteMessagesId/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable Integer id) {
        messageServiceInter.deleteMessageById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
