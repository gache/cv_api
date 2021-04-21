package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Message;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface IMessageService {

    List<Message> findAll();

    Message findById(Long id);

    Message save(Message message);

    public void delete(Long id);

}
