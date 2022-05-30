package com.inti.TD1Rest.repository;

import com.inti.TD1Rest.model.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>
{

}
