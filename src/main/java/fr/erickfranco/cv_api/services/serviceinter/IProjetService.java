package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface IProjetService {

    List<Projet> findAll();

    Page<Projet> findAll(Pageable pageable);

    Projet findById(Integer id);

    Projet save(Projet projet);

    public void delete(Integer id);
}
