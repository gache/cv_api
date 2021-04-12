package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.models.User;
import fr.erickfranco.cv_api.repositories.UserRepository;
import fr.erickfranco.cv_api.services.serviceinter.UserServiceInter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Erick Franco
 */
@Service
public class UserServiceImpl implements UserServiceInter {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        Optional<User> user = userRepository.findByLogin(login);
        return user;
    }

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByLogin(login);
        return new User(user.get().getUsername(), user.get().getPassword(), AuthorityUtils.NO_AUTHORITIES);
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
