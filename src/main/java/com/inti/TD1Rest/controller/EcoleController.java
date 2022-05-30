package com.inti.TD1Rest.controller;

import java.util.List;

import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EcoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
}
