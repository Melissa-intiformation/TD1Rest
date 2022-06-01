package com.inti.TD1Rest.repository;

import java.util.List;

import com.inti.TD1Rest.model.Professeur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer>
{
	@Query(value = "select p.* from professeur p, ecole e, ecole_professeur ep\r\n"
			+ "where p.id = ep.id_prof and e.id = ep.id_ecole and e.id =:id \r\n"
			+ "order by salaire", nativeQuery = true)
	List<Professeur> sortProfBySalaireBySchoolId(@Param("id") int id);
}
