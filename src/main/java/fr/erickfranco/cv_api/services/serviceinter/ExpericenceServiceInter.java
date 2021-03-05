package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Experience;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface ExpericenceServiceInter {
    List<Experience> findAll();

    Experience findById(Integer id);

    Experience saveExperience(Experience experience);

    void deleteById(Integer id);
}
