package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Erick Franco
 */
@Service
public class UserServiceImpl  {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Objects.requireNonNull(username);
//        User user = userRepository.findUserWithName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return user;
//    }

//    @Override
//    public List<User> findAllUser() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public Optional<User> findUserById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        userRepository.deleteById(id);
//    }
}
