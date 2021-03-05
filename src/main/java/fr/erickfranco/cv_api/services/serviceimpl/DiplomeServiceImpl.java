package fr.erickfranco.cv_api.services.serviceimpl;

import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.BadRequestExcepton;
import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import fr.erickfranco.cv_api.models.Diplome;
import fr.erickfranco.cv_api.repositories.DiplomeRepository;
import fr.erickfranco.cv_api.services.serviceinter.DiplomeServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Erick Franco
 */
@Service
public class DiplomeServiceImpl implements DiplomeServiceInter {

    private final DiplomeRepository diplomeRepository;

    @Autowired
    public DiplomeServiceImpl(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }


    @Override
    public List<Diplome> findAllDiplome() {
        return diplomeRepository.findAll();
    }

    @Override
    public Diplome saveDiplome(Diplome diplome) {
        if (diplome.getNomDiplome().isEmpty()) {
            throw new BadRequestExcepton("Le nom du diplome est obligatoire");
        }
        return diplomeRepository.save(diplome);
    }

    @Override
    public Diplome findDiplomeById(Integer id) {
        if (!diplomeRepository.existsById(id)) {
            throw new NotFoundExcepton("Le Diplôme avec l'id " + id + " n'existe pas ");
        }
        return diplomeRepository.getOne(id);
    }

    @Override
    public void deleteDiplomeById(Integer id) {
        if (!diplomeRepository.existsById(id)) {
            throw new NotFoundExcepton("Le Diplome que vous souhaitez l'eliminer avec l'id numéro: " + id + " n'existe pas ");
        }
        diplomeRepository.deleteById(id);
    }
}
