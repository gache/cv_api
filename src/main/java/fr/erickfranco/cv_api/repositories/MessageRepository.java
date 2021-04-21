package fr.erickfranco.cv_api.repositories;

import fr.erickfranco.cv_api.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Long> {
}
