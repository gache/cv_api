package fr.erickfranco.cv_api.services;

import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import fr.erickfranco.cv_api.models.Experience;
import fr.erickfranco.cv_api.repositories.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    public final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<Experience> findAll() {
        return experienceRepository.findAll();
    }

    public Experience findById(Integer id) {
        if (!experienceRepository.existsById(id)) {
            throw new NotFoundExcepton("Cette Experience avec l'id " + id + " n'existe pas ");
        }
        return experienceRepository.getOne(id);
    }

    public Experience saveExperience(Experience parcour) {
        return experienceRepository.save(parcour);
    }

    public void deleteById(Integer id) {
        if (!experienceRepository.existsById(id)) {
            throw new NotFoundExcepton("L'experience que vous souhaitez l'eliminer avec l'id " + id + " n'existe pas ");
        }
        experienceRepository.deleteById(id);
    }


}
