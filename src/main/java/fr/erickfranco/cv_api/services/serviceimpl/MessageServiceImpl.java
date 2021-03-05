package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.BadRequestExcepton;
import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import fr.erickfranco.cv_api.models.Message;
import fr.erickfranco.cv_api.repositories.MessageRepository;
import fr.erickfranco.cv_api.services.serviceinter.MessageServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class MessageServiceImpl implements MessageServiceInter {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> findAllMessage() {
        return messageRepository.findAll();
    }

    @Override
    public void deleteMessageById(Integer id) {
        if (!messageRepository.existsById(id)) {
            throw new NotFoundExcepton("Le Message que vous souhaitez l'eliminer avec l'id numéro " + id + " n'existe pas ");
        }
        messageRepository.deleteById(id);
    }

    @Override
    public Message findMessageById(Integer id) {
        if (!messageRepository.existsById(id)) {
            throw new NotFoundExcepton("Le projet avec l'id " + id + " n'existe pas ");
        }
        return messageRepository.getOne(id);
    }

    @Override
    public Message saveMessage(Message message) {
        if (message.getEmail().isEmpty() || message.getEmail() == null) {
            throw new BadRequestExcepton("Le champ Email est obligatoire");
        }
        messageRepository.save(message);
        return message;
    }
}
