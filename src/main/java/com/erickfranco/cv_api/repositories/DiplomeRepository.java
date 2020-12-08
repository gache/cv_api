package com.erickfranco.cv_api.repositories;


import com.erickfranco.cv_api.models.Diplome;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface DiplomeRepository extends JpaRepository<Diplome, Integer> {

}
