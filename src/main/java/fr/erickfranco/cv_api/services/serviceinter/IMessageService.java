package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface IMessageService {

    List<Message> findAllMessages();

    public Page<Message> findAll(Pageable pageable);

    Message findMessageById(Integer id);

    Message saveMessage(Message message);

    public void deleteMessageById(Integer id);

}
