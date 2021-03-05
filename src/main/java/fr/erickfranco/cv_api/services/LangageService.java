package fr.erickfranco.cv_api.services;

import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import fr.erickfranco.cv_api.models.Langage;
import fr.erickfranco.cv_api.repositories.LangageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangageService {

    private final LangageRepository langageRepository;

    @Autowired
    public LangageService(LangageRepository langageRepository) {
        this.langageRepository = langageRepository;
    }

    public List<Langage> findAllLangage() {
        return langageRepository.findAll();
    }

    public Langage findLangageById(Integer id) {
        if (!langageRepository.existsById(id)) {
            throw new NotFoundExcepton("Le projet avec l'id " + id + " n'existe pas ");
        }
        return langageRepository.getOne(id);
    }


    public Langage createLangage(Langage langage) {
        return langageRepository.save(langage);
    }


    public void deleteLangageById(Integer id) {
        if (!langageRepository.existsById(id)) {
            throw new NotFoundExcepton("Le Lanagage que vous souhaitez l'eliminer avec l'id " + id + " n'existe pas ");
        }
        langageRepository.deleteById(id);
    }

}
