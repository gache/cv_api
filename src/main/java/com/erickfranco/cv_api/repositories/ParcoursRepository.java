package com.erickfranco.cv_api.repositories;

import com.erickfranco.cv_api.models.Parcour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcoursRepository extends JpaRepository<Parcour, Integer> {
}
