package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.models.Experience;
import fr.erickfranco.cv_api.repositories.ExperienceRepository;
import fr.erickfranco.cv_api.services.serviceinter.IExpericenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class ExperienceServiceImpl implements IExpericenceService {

    @Autowired
    private final ExperienceRepository experienceRepository;

    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }


    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience findById(Long id) {
        return experienceRepository.findById(id).orElse(null);
    }

    @Override
    public Experience save(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public void delete(Long id) {
        experienceRepository.deleteById(id);

    }
}
