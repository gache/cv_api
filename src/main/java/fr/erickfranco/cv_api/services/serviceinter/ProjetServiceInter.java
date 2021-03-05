package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Projet;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface ProjetServiceInter {

    List<Projet> findAllProjet();

    Projet findProjetById(Integer id);

    Projet saveProjet(Projet projet);

    void deleteById(Integer id);
}
