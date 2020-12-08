package com.erickfranco.cv_api.services.interfaceService;

import com.erickfranco.cv_api.models.Diplome;
import com.erickfranco.cv_api.models.Projet;

import java.util.List;
import java.util.Optional;

public interface IProjetSerive {

    List<Projet> findAllProjet();

    Optional<Projet> findProjetById(Integer id);

    Projet createProjet(Projet projet);

    void deleteProjetById(Integer id);
}
