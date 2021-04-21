package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Diplome;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface IDiplomeService {

    List<Diplome> findAll();

    public Diplome findById(Long id);

    Diplome save(Diplome diplome);

    public void delete(Long id);

}
