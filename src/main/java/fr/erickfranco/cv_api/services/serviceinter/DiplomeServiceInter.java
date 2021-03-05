package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Diplome;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface DiplomeServiceInter {

    List<Diplome> findAllDiplome();

    Diplome saveDiplome(Diplome diplome);

    Diplome findDiplomeById(Integer id);

    void deleteDiplomeById(Integer id);

}
