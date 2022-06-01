package com.inti.TD1Rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.inti.TD1Rest.model.Etudiant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EtudiantRepositoryTests
{
	@Autowired
	EtudiantRepository etudiantRepository;

	Etudiant e1;

	@BeforeEach
	public void setUp()
	{
		e1 = new Etudiant("Toto", "Titi", "tt@gmail.fr", "070809", 2);
	}

	@Test
	public void testSaveStudent()
	{
		// Given

		// When
		Etudiant savedEtudiant = etudiantRepository.save(e1);

		// Then
		assertThat(savedEtudiant).isNotNull(); // normalement ce test suffit

	}

	@Test
	public void testGetAllStudents()
	{
		// Given

		// When
		List<Etudiant> listeEtudiant = etudiantRepository.findAll();

		// Then
		assertThat(listeEtudiant).isNotEmpty(); // normalement ce test suffit
		assertThat(listeEtudiant).hasSize((int) etudiantRepository.count()); 
	}
	
	@Test
	public void testGetAllStudentsInLyon()
	{
		// Given

		// When
		List<Etudiant> listeEtudiant = etudiantRepository.findByVilleLyon();

		// Then
		assertThat(listeEtudiant).isNotEmpty(); // normalement ce test suffit
		assertThat(listeEtudiant.get(0).getEcole().getVille().equals("Lyon"));
	}
	
	@Test
	public void testGetAllStudentsByProf()
	{
		// Given
		int idProf = 1;
		
		// When
		List<Etudiant> listeEtudiant = etudiantRepository.findByProf(idProf);

		// Then
		assertThat(listeEtudiant).isNotEmpty(); // normalement ce test suffit
	}
	
	
}
