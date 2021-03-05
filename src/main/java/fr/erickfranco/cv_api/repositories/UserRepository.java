package fr.erickfranco.cv_api.repositories;

import fr.erickfranco.cv_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Erick Franco
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(" select u from User u " +
            " where u.username = ?1")
    Optional<User> findUserWithName(String username);

    void deleteById(Integer id);


}
