package fr.erickfranco.cv_api.repositories;

import fr.erickfranco.cv_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Erick Franco
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
