package com.inti.TD1Rest.controller;

import java.util.List;

import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EcoleRepository;

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
public class EcoleController
{
	@Autowired
	EcoleRepository ecoleRepository;
	
	@GetMapping("/getEtudiantsFromEcole/{id}")
	public List<Etudiant> getEtudiantsFromEcole(@PathVariable("id") int idEcole) {
		Ecole ecole = (Ecole) ecoleRepository.getReferenceById(idEcole);
		return ecole.getListeEtudiant();
	}

	@GetMapping("/schools")
	public ResponseEntity<List<Ecole>> getAllSchools()
	{
		return new ResponseEntity<List<Ecole>>(ecoleRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping("/saveSchool")
	public ResponseEntity<Ecole> saveStudent(@RequestBody Ecole ecole)
	{
		return new ResponseEntity<Ecole>(ecoleRepository.save(ecole), HttpStatus.CREATED);
	}

	@PutMapping("/updateSchool/{id}")
	public String updateSchool(@RequestBody Ecole ecole, @PathVariable int id)
	{
//		Ecole e1 = ecoleRepository.getReferenceById(id);
		ecoleRepository.save(ecole);
		return "Ecole : " + ecole + " updated";
	}

	@DeleteMapping("/deleteSchool")
	public String deleteSchool(@RequestParam("id") int id)
	{
		ecoleRepository.deleteById(id);
		return "School deleted";
	}
	
	@GetMapping("/schoolByEmail/{email}")
	public Ecole getSchoolByEmail(@PathVariable String email)
	{
		return ecoleRepository.findSchoolByEmail(email);
	}
}
