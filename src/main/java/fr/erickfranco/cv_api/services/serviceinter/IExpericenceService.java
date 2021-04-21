package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Experience;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface IExpericenceService {

    List<Experience> findAll();

    Experience findById(Long id);

    Experience save(Experience experience);

    public void delete(Long id);
}
