package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.models.Message;
import fr.erickfranco.cv_api.repositories.MessageRepository;
import fr.erickfranco.cv_api.services.serviceinter.IMessageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class MessageServiceImpl implements IMessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message findById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void delete(Long id) {
        messageRepository.deleteById(id);
    }
}
