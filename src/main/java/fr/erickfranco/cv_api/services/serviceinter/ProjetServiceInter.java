package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Projet;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface ProjetServiceInter {

    List<Projet> findAllProjet();

    Optional<Projet> findProjetById(Integer id);

    Projet saveProjet(Projet projet);

    void deleteById(Integer id);
}
