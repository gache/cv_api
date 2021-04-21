package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.models.Diplome;
import fr.erickfranco.cv_api.repositories.DiplomeRepository;
import fr.erickfranco.cv_api.services.serviceinter.IDiplomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class DiplomeServiceImpl implements IDiplomeService {

    @Autowired
    private final DiplomeRepository diplomeRepository;

    public DiplomeServiceImpl(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }


    @Override
    public List<Diplome> findAll() {
        return diplomeRepository.findAll();
    }

    @Override
    public Diplome findById(Long id) {
        return diplomeRepository.findById(id).orElse(null);
    }

    @Override
    public Diplome save(Diplome diplome) {
        return diplomeRepository.save(diplome);
    }

    @Override
    public void delete(Long id) {
        diplomeRepository.deleteById(id);
    }
}
