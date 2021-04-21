package fr.erickfranco.cv_api.repositories;

import fr.erickfranco.cv_api.models.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Erick Franco
 */
public interface UserRepository extends CrudRepository<Utilisateur, Long> {

    public Utilisateur findByUsername(String username);

    @Query("select u from Utilisateur u where u.username=?1")
    public Utilisateur findByUsername2(String username);


}
