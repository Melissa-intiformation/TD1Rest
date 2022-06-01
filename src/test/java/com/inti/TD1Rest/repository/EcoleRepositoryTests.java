package com.inti.TD1Rest.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.inti.TD1Rest.model.Ecole;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EcoleRepositoryTests
{
	@Autowired
	EcoleRepository ecoleRepository;
	
	Ecole e1;
	
	@BeforeEach
	public void SetUp() {
		e1 = new Ecole("Inti", "adresse", "cp", "ville");
	}
	
	@Test
	public void testGetAllStudentsInLyon()
	{
		// Given

		// When
		Ecole ecole = ecoleRepository.findSchoolByNomEtPrenom("Jean", "Pierre");

		// Then
		assertThat(ecole).isNotNull(); // normalement ce test suffit
		assertThat(ecole.getNom()).isEqualTo("Adaming");
	}
}
