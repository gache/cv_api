package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Diplome;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface DiplomeService {

    List<Diplome> findAllDiplome();

    Diplome createDiplome(Diplome diplome);

    Optional<Diplome> findDiplomeById(Integer id);

    void deleteDiplomeById(Integer id);

}
