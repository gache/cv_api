package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
public interface UserServiceInter extends UserDetailsService {

    Optional<User> findUserWithName(String username);

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;

    List<User> findAllUser();

    Optional<User> findUserById(Integer id);

    User saveUser(User user);

    void deleteById(Integer id);
}
