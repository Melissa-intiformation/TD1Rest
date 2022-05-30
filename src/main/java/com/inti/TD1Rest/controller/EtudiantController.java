package com.inti.TD1Rest.controller;

import java.util.List;

import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EtudiantController
{
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@GetMapping("/test")
	public String hello() {
		return "Hello World! ";
	}
	
	@GetMapping("/getEtudiants")
	public List<Etudiant> getEtudiants() {
		return etudiantRepository.findAll();
	}
	
	@GetMapping("/getEtudiant/{id}")
	public Etudiant getEtudiant(@PathVariable("id") int id) {
		return etudiantRepository.getReferenceById(id);
	}
	
	@GetMapping("/saveEtudiant")
	public String saveEtudiant() {
		Etudiant e = new Etudiant("Etudiant1","Etudiant1",2);
		etudiantRepository.save(e);
		return "Etudiant saved";
	}
	
	@GetMapping("/updateEtudiant/{id}")
	public String updateEtudiant(@PathVariable("id") int id) {
		Etudiant e = etudiantRepository.getReferenceById(id);
		e.setTelephone("0000000000");
		etudiantRepository.save(e);
		return "Etudiant updated";
	}
	
	@GetMapping("/deleteEtudiant/{id}")
	public String deleteEtudiant(@PathVariable("id") int id) {
		etudiantRepository.deleteById(id);
		return "Etudiant deleted";
	}
	
	
	
}
