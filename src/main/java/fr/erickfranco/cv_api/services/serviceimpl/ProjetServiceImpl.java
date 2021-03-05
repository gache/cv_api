package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.BadRequestExcepton;
import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import fr.erickfranco.cv_api.models.Projet;
import fr.erickfranco.cv_api.repositories.ProjetRepository;
import fr.erickfranco.cv_api.services.serviceinter.ProjetServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class ProjetServiceImpl implements ProjetServiceInter {

    private final ProjetRepository projetRepository;

    @Autowired
    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public List<Projet> findAllProjet() {
        return projetRepository.findAll();
    }

    @Override
    public Projet findProjetById(Integer id) {
        if (!projetRepository.existsById(id)) {
            throw new NotFoundExcepton("Le projet avec l'id " + id + " n'existe pas ");
        }
        return projetRepository.getOne(id);
    }

    @Override
    public Projet saveProjet(Projet projet) {
        if (projet.getNom() == null || projet.getNom().isEmpty()) {
            throw new BadRequestExcepton("Le champ Nom est obligatoire");
        }
        projetRepository.save(projet);
        return projet;
    }

    @Override
    public void deleteById(Integer id) {
        if (!projetRepository.existsById(id)) {
            throw new NotFoundExcepton("Le Projet que vous souhaitez l'eliminer avec l'id numéro " + id + " n'existe pas ");
        }
        projetRepository.deleteById(id);
    }
}
