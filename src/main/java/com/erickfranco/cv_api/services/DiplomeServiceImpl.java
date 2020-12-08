package com.erickfranco.cv_api.services;


import com.erickfranco.cv_api.models.Diplome;
import com.erickfranco.cv_api.repositories.DiplomeRepository;
import com.erickfranco.cv_api.services.interfaceService.InterDiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DiplomeServiceImpl implements InterDiplomeService {


    private final DiplomeRepository diplomeRepository;

    @Autowired
    public DiplomeServiceImpl(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    @Override
    public List<Diplome> findAllDiplome() {
        return diplomeRepository.findAll();
    }

    @Override
    public Optional<Diplome> findDiplomeById(Integer id) {
        return diplomeRepository.findById(id);
    }

    @Override
    public Diplome createDiplome(Diplome diplome) {
        return diplomeRepository.save(diplome);
    }

    @Override
    public void deleteDiplomeById(Integer id) {
        diplomeRepository.deleteById(id);
    }
}
