package com.inti.TD1Rest.controller;

import java.util.List;

import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.model.Professeur;
import com.inti.TD1Rest.repository.EcoleRepository;
import com.inti.TD1Rest.repository.ProfesseurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfesseurController
{
	@Autowired
	ProfesseurRepository professeurRepository;

	@GetMapping("/teachers")
	public ResponseEntity<List<Professeur>> getAllTeachers()
	{
		return new ResponseEntity<List<Professeur>>(professeurRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/saveTeacher")
	public ResponseEntity<Professeur> saveTeacher(@RequestBody Professeur professeur)
	{
		return new ResponseEntity<Professeur>(professeurRepository.save(professeur), HttpStatus.CREATED);
	}

	@PutMapping("/updateTeacher/{id}")
	public String updateTeacher(@RequestBody Professeur professeur, @PathVariable int id)
	{
		professeurRepository.save(professeur);
		return "Professeur : " + professeur + " updated";
	}

	@DeleteMapping("/deleteTeacher")
	public String deleteTeacher(@RequestParam("id") int id)
	{
		professeurRepository.deleteById(id);
		return "Professeur deleted";
	}
}
