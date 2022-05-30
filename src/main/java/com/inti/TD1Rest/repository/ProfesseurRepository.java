package com.inti.TD1Rest.repository;

import com.inti.TD1Rest.model.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer>
{

}
