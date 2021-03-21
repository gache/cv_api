package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface UserServiceInter extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
    List<User> findAllUser();

    User findUserById(Long id);

    User saveUser(User user);

    void deleteById(Long id);
}
