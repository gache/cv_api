package fr.erickfranco.cv_api.services;


import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.BadRequestExcepton;
import fr.erickfranco.cv_api.configurations.exceptionconfig.exception.NotFoundExcepton;
import fr.erickfranco.cv_api.models.Diplome;
import fr.erickfranco.cv_api.repositories.DiplomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DiplomeService {

    private final DiplomeRepository diplomeRepository;

    @Autowired
    public DiplomeService(DiplomeRepository diplomeRepository) {
        this.diplomeRepository = diplomeRepository;
    }

    public List<Diplome> findAllDiplome() {
        return diplomeRepository.findAll();
    }


    public Diplome findDiplomeById(Integer id) {
        if (!diplomeRepository.existsById(id)) {
            throw new NotFoundExcepton("Le Diplôme avec l'id " + id + " n'existe pas ");
        }
        return diplomeRepository.getOne(id);
    }


    public Diplome createDiplome(Diplome diplome) {
        if (diplome.getNomDiplome().isEmpty()) {
            throw new BadRequestExcepton("Le nom du diplome est obligatoire");
        }
        return diplomeRepository.save(diplome);
    }


    public void deleteDiplomeById(Integer id) {
        if (!diplomeRepository.existsById(id)) {
            throw new NotFoundExcepton("Le Diplome que vous souhaitez l'eliminer avec l'id " + id + " n'existe pas ");
        }
        diplomeRepository.deleteById(id);
    }
}
