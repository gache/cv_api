package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Experience;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface ExpericenceService {
    List<Experience> findAll();

    Optional<Experience> findById(Integer id);

    Experience saveExperience(Experience experience);

    void deleteById(Integer id);
}
