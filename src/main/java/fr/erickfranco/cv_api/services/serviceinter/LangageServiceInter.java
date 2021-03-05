package fr.erickfranco.cv_api.services.serviceinter;

import fr.erickfranco.cv_api.models.Langage;

import java.util.List;

/**
 * @author Erick Franco
 */
public interface LangageServiceInter {

    List<Langage> findAllLangage();

    Langage findLangageById(Integer id);

    Langage saveLangage(Langage langage);

    void deleteLangageById(Integer id);
}
