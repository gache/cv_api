package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Message;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface MessageServiceInter {

    List<Message> findAllMessage();

    Optional<Message> findMessageById(Integer id);

    Message saveMessage(Message message);

    void deleteMessageById(Integer id);
}
