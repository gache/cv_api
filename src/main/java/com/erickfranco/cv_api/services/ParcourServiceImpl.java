package com.erickfranco.cv_api.services;

import com.erickfranco.cv_api.models.Parcour;
import com.erickfranco.cv_api.repositories.ParcoursRepository;
import com.erickfranco.cv_api.services.interfaceService.InterParcourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParcourServiceImpl implements InterParcourService {


    public final ParcoursRepository parcoursRepository;

    @Autowired
    public ParcourServiceImpl(ParcoursRepository parcoursRepository) {
        this.parcoursRepository = parcoursRepository;
    }

    @Override
    public List<Parcour> findAll() {
        return parcoursRepository.findAll();
    }

    @Override
    public Optional<Parcour> findById(Integer id) {
        return parcoursRepository.findById(id);
    }

    @Override
    public Parcour save(Parcour parcour) {
        return parcoursRepository.save(parcour);
    }

    @Override
    public void deleteById(Integer id) {
        parcoursRepository.deleteById(id);
    }
}
