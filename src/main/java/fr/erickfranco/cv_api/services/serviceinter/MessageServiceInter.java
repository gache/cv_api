package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Message;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface MessageServiceInter {

    List<Message> findAllMessage();

    void deleteMessageById(Integer id);

    Message findMessageById(Integer id);

    Message saveMessage(Message message);


}
