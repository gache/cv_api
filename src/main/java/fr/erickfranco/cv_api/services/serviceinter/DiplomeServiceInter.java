package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Diplome;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface DiplomeServiceInter {

    List<Diplome> findAllDiplome();

    Diplome saveDiplome(Diplome diplome);

    Optional<Diplome> findDiplomeById(Integer id);

    void deleteDiplomeById(Integer id);

}
