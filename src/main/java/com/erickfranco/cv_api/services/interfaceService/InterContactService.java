package com.erickfranco.cv_api.services.interfaceService;

import com.erickfranco.cv_api.models.Contact;


import java.util.List;
import java.util.Optional;


public interface InterContactService {

    List<Contact> findAllMessage();

    Optional<Contact> findMessageById(Integer id);

    Contact createMessage(Contact diplome);

    void deleteMessageById(Integer id);
}
