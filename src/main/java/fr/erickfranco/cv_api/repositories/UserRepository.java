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

    public User findByEmail(String email);
    Optional<User> findByLogin(String login);
    @Override
    @Query(value = "select COUNT(*) from users WHERE users.is_admin <> 1 OR users.is_admin IS NULL", nativeQuery = true)
    public long count();

}
