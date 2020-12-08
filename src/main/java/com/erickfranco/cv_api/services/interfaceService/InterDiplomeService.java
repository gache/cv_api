package com.erickfranco.cv_api.services.interfaceService;

import com.erickfranco.cv_api.models.Diplome;

import java.util.List;
import java.util.Optional;

public interface InterDiplomeService {

    List<Diplome> findAllDiplome();

    Optional<Diplome> findDiplomeById(Integer id);

    Diplome createDiplome(Diplome diplome);

    void deleteDiplomeById(Integer id);

}
