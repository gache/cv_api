package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Langage;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface ILangageService {

    List<Langage> findAllLangages();

    Langage findLangageById(Integer id);

    Langage saveLangage(Langage langage);

    public void deleteById(Integer id);
}
