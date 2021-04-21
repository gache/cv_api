package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Utilisateur;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface UserServiceInter  {

    Utilisateur saveUser(Utilisateur user);

    Optional<Utilisateur> findUserById(Long id);

    void deleteById(Long id);

    Optional<Utilisateur> findByLogin(String login);


    List<Utilisateur> findAllUser();


}
