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

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    List<User> findAllUser();

    Optional<User> findUserById(Long id);

    User saveUser(User user);

    void deleteById(Long id);
}
