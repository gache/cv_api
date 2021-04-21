package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.models.Langage;
import fr.erickfranco.cv_api.repositories.LangageRepository;
import fr.erickfranco.cv_api.services.serviceinter.ILangageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class LangageServiceImpl implements ILangageService {

    @Autowired
    private final LangageRepository langageRepository;

    public LangageServiceImpl(LangageRepository langageRepository) {
        this.langageRepository = langageRepository;
    }

    @Override
    public List<Langage> findAll() {
        return langageRepository.findAll();
    }

    @Override
    public Langage findById(Long id) {
        return langageRepository.findById(id).orElse(null);
    }

    @Override
    public Langage save(Langage langage) {
        return langageRepository.save(langage);
    }

    @Override
    public void delete(Long id) {
        langageRepository.deleteById(id);

    }
}
