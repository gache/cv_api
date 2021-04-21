package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author Erick Franco
 */
@Service
public class UserServiceImpl {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
