package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.models.Projet;
import fr.erickfranco.cv_api.repositories.ProjetRepository;
import fr.erickfranco.cv_api.services.serviceinter.IProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class ProjetServiceImpl implements IProjetService {

    @Autowired
    private final ProjetRepository projetRepository;

    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public List<Projet> findAll() {
        return projetRepository.findAll();
    }

    @Override
    public Page<Projet> findAll(Pageable pageable) {
        return projetRepository.findAll(pageable);
    }

    @Override
    public Projet findById(Long id) {
        return projetRepository.findById(id).orElse(null);
    }

    @Override
    public Projet save(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public void delete(Long id) {
        projetRepository.deleteById(id);
    }
}
