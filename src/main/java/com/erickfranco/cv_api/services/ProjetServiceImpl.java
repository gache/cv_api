package com.erickfranco.cv_api.services;


import com.erickfranco.cv_api.models.Projet;
import com.erickfranco.cv_api.repositories.ProjetRepository;
import com.erickfranco.cv_api.services.interfaceService.IProjetSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements IProjetSerive {

    private final ProjetRepository projetRepository;

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public List<Projet> findAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Optional<Projet> findProjetById(Integer id) {
        return projetRepository.findById(id);
    }

    @Override
    public Projet createProjet(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void deleteProjetById(Integer id) {
        projetRepository.deleteById(id);
    }
}
