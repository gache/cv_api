package fr.erickfranco.cv_api.repositories;

import fr.erickfranco.cv_api.models.Projet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProjetRepository extends JpaRepository<Projet, Long> {

}
