package fr.erickfranco.cv_api.repositories;

import fr.erickfranco.cv_api.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}
