package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Projet;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface IProjetService {

    List<Projet> findAllProjets();

    Projet findById(Integer id);

    Projet saveProjet(Projet projet);

    public void deleteById(Integer id);
}
