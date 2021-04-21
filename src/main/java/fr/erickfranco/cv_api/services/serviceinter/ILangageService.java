package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Langage;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface ILangageService {

    List<Langage> findAll();

    Langage findById(Long id);

    Langage save(Langage langage);

    public void delete(Long id);
}
