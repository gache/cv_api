package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import fr.erickfranco.cv_api.models.Experience;
import fr.erickfranco.cv_api.repositories.ExperienceRepository;
import fr.erickfranco.cv_api.services.serviceinter.ExpericenceServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class ExperienceServiceImpl implements ExpericenceServiceInter {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    @Override
    public Experience findById(Integer id) {
        if (!experienceRepository.existsById(id)) {
            throw new NotFoundExcepton("Cette Experience avec l'id " + id + " n'existe pas ");
        }
        return experienceRepository.getOne(id);
    }

    @Override
    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public void deleteById(Integer id) {
        if (!experienceRepository.existsById(id)) {
            throw new NotFoundExcepton("L'experience que vous souhaitez l'eliminer avec l'id numéro " + id + " n'existe pas ");
        }
        experienceRepository.deleteById(id);
    }
}
