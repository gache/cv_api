package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Utilisateur;

/**
 * @author Erick Franco
 */
public interface IUtilisateurService {

    public Utilisateur findByUsername(String username);
}
