package com.erickfranco.cv_api.services.interfaceService;

import com.erickfranco.cv_api.models.Parcour;

import java.util.List;
import java.util.Optional;

public interface InterParcourService {

    List<Parcour> findAll();

    Optional<Parcour> findById(Integer id);

    Parcour save(Parcour parcour);

    void deleteById(Integer id);
}
