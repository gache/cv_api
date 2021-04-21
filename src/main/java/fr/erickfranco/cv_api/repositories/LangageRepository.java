package fr.erickfranco.cv_api.repositories;

import fr.erickfranco.cv_api.models.Langage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangageRepository extends JpaRepository<Langage, Long> {
}
