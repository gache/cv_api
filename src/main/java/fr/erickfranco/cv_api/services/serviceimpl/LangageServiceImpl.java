package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import fr.erickfranco.cv_api.models.Langage;
import fr.erickfranco.cv_api.repositories.LangageRepository;
import fr.erickfranco.cv_api.services.serviceinter.LangageServiceInter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class LangageServiceImpl implements LangageServiceInter {
    private final LangageRepository langageRepository;

    public LangageServiceImpl(LangageRepository langageRepository) {
        this.langageRepository = langageRepository;
    }


    @Override
    public List<Langage> findAllLangage() {
        return langageRepository.findAll();
    }

    @Override
    public Langage findLangageById(Integer id) {
        if (!langageRepository.existsById(id)) {
            throw new NotFoundExcepton("Le projet avec l'id " + id + " n'existe pas ");
        }
        return langageRepository.getOne(id);
    }

    @Override
    public Langage saveLangage(Langage langage) {
        return langageRepository.save(langage);
    }

    @Override
    public void deleteLangageById(Integer id) {
        if (!langageRepository.existsById(id)) {
            throw new NotFoundExcepton("Le Lanagage que vous souhaitez l'eliminer avec l'id numéro " + id + " n'existe pas ");
        }
        langageRepository.deleteById(id);
    }
}
