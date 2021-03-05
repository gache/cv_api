package fr.erickfranco.cv_api.repositories;


import fr.erickfranco.cv_api.models.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {

}
