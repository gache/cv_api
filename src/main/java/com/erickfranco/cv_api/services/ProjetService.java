package com.erickfranco.cv_api.services;


import com.erickfranco.cv_api.config.exception.BadRequestException;
import com.erickfranco.cv_api.config.exception.NotFoundException;
import com.erickfranco.cv_api.models.Projet;
import com.erickfranco.cv_api.repositories.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetService {

    private final ProjetRepository projetRepository;

    @Autowired
    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    public List<Projet> findAllProjet() {
        return projetRepository.findAll();
    }

    public Projet findProjetById(Integer id) {
        if (!projetRepository.existsById(id)) {
            throw new NotFoundException("Le projet avec l'id " + id + " n'existe pas ");
        }
        return projetRepository.getOne(id);
    }

    public Projet createProjet(Projet projet) {
        if (projet.getNom() == null || projet.getNom().isEmpty()) {
            throw new BadRequestException("Le champ Nom est obligatoire");
        }
        projetRepository.save(projet);
        return projet;
    }

    public void deleteById(Integer id) {
        projetRepository.deleteById(id);
    }
}





