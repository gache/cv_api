package com.erickfranco.cv_api.services;


import com.erickfranco.cv_api.config.exception.NotFoundException;
import com.erickfranco.cv_api.models.Diplome;
import com.erickfranco.cv_api.repositories.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DiplomeService {

    private final DiplomeRepository diplomeRepository;

    @Autowired
    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    public List<Diplome> findAllDiplome() {
        return diplomeRepository.findAll();
    }


    public Diplome findDiplomeById(Integer id) {
        if (!diplomeRepository.existsById(id)) {
            throw new NotFoundException("Le Diplôme avec l'id " + id + " n'existe pas ");
        }
        return diplomeRepository.getOne(id);
    }


    public Diplome createDiplome(Diplome diplome) {
        return diplomeRepository.save(diplome);
    }

    public void deleteDiplomeById(Integer id) {
        diplomeRepository.deleteById(id);
    }
}
