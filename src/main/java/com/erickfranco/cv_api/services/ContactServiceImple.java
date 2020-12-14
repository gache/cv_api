package com.erickfranco.cv_api.services;

import com.erickfranco.cv_api.models.Contact;
import com.erickfranco.cv_api.repositories.ContactRepository;
import com.erickfranco.cv_api.services.interfaceService.InterContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImple implements InterContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImple(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> findAllMessage() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> findMessageById(Integer id) {
        return contactRepository.findById(id);
    }

    @Override
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @Override
    public void deleteMessageById(Integer id) {
        contactRepository.deleteById(id);

    }
}
