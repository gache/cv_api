package com.erickfranco.cv_api.services.interfaceService;

import com.erickfranco.cv_api.models.Diplome;
import com.erickfranco.cv_api.models.Langage;

import java.util.List;
import java.util.Optional;

public interface InterLangageService {

    List<Langage> findAllLangage();

    Optional<Langage> findLangageById(Integer id);

    Langage createLangage(Langage langage);

    void deleteLangageById(Integer id);
}
