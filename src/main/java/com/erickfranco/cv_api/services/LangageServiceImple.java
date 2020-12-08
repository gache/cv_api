package com.erickfranco.cv_api.services;

import com.erickfranco.cv_api.models.Langage;
import com.erickfranco.cv_api.repositories.LangageRepository;
import com.erickfranco.cv_api.services.interfaceService.InterLangageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LangageServiceImple implements InterLangageService {

    private final LangageRepository langageRepository;

    @Autowired
    public LangageServiceImple(LangageRepository langageRepository) {
        this.langageRepository = langageRepository;
    }


    @Override
    public List<Langage> findAllLangage() {
        return langageRepository.findAll();
    }

    @Override
    public Optional<Langage> findLangageById(Integer id) {
        return langageRepository.findById(id);
    }

    @Override
    public Langage createLangage(Langage langage) {
        return langageRepository.save(langage);
    }

    @Override
    public void deleteLangageById(Integer id) {
        langageRepository.deleteById(id);
    }
}
