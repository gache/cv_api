package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Diplome;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface IDiplomeService {

    List<Diplome> findAllDiplomes();

    Diplome findDiplomeById(Long id);

    Diplome saveDiplome(Diplome diplome);

    public void deleteDiplomeById(Long id);

}
