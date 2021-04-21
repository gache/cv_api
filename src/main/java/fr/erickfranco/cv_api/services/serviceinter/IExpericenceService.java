package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Experience;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface IExpericenceService {

    List<Experience> findAllExperiences();

    Experience findById(Long id);

    Experience saveExperience(Experience experience);

    public void deleteById(Long id);
}
