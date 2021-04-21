package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.User;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface UserServiceInter  {

    User saveUser(User user);

    Optional<User> findUserById(Long id);

    void deleteById(Long id);

    Optional<User> findByLogin(String login);


    List<User> findAllUser();


}
