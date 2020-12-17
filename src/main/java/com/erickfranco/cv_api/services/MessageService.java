package com.erickfranco.cv_api.services;

import com.erickfranco.cv_api.config.exception.BadRequestException;
import com.erickfranco.cv_api.config.exception.NotFoundException;
import com.erickfranco.cv_api.models.Message;
import com.erickfranco.cv_api.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public List<Message> findAllMessage() {
        return messageRepository.findAll();
    }


    public Message findMessageById(Integer id) {
        if (!messageRepository.existsById(id)) {
            throw new NotFoundException("Le projet avec l'id " + id + " n'existe pas ");
        }
        return messageRepository.getOne(id);
    }


    public Message saveMessage(Message message) {
        if (message.getEmail().isEmpty() || message.getEmail() == null) {
            throw new BadRequestException("Le champ Email est obligatoire");
        }
        messageRepository.save(message);
        return message;
    }

    public void deleteMessageById(Integer id) {
        if (!messageRepository.existsById(id)) {
            throw new NotFoundException("Le Message que vous souhaitez l'eliminer avec l'id " + id + " n'existe pas ");
        }
         messageRepository.deleteById(id);
    }
}
