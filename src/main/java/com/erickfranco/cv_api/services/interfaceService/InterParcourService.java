package com.erickfranco.cv_api.services.interfaceService;

import com.erickfranco.cv_api.models.Experience;

import java.util.List;
import java.util.Optional;

public interface InterParcourService {

    List<Experience> findAll();

    Optional<Experience> findById(Integer id);

    Experience save(Experience parcour);

    void deleteById(Integer id);
}
