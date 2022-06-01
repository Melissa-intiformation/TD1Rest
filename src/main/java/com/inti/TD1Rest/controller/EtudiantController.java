package com.inti.TD1Rest.controller;

import java.util.List;

import com.inti.TD1Rest.model.Ecole;
import com.inti.TD1Rest.model.Etudiant;
import com.inti.TD1Rest.repository.EcoleRepository;
import com.inti.TD1Rest.repository.EtudiantRepository;

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
public class EtudiantController
{
	@Autowired
	EtudiantRepository etudiantRepository;
	
	@Autowired
	EcoleRepository ecoleRepository;

	@GetMapping("/test")
	public String hello()
	{
		return "Hello World! ";
	}

//	@GetMapping("/getEtudiants")
//	public List<Etudiant> getEtudiants() {
//		return etudiantRepository.findAll();
//	}

	@GetMapping("/students")
	public ResponseEntity<List<Etudiant>> getAllStudents()
	{
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/getEtudiant/{id}")
	public Etudiant getEtudiant(@PathVariable("id") int id)
	{
		return etudiantRepository.getReferenceById(id);
	}

//	@GetMapping("/saveEtudiant")
//	public String saveEtudiant() {
//		Etudiant e = new Etudiant("Etudiant1","Etudiant1",2);
//		etudiantRepository.save(e);
//		return "Etudiant saved";
//	}

	@PostMapping("/saveStudent")
	public ResponseEntity<Etudiant> saveStudent(@RequestBody Etudiant etudiant)
	{
		return new ResponseEntity<Etudiant>(etudiantRepository.save(etudiant), HttpStatus.CREATED);
	}

//	@GetMapping("/updateEtudiant/{id}")
//	public String updateEtudiant(@PathVariable("id") int id) {
//		Etudiant e = etudiantRepository.getReferenceById(id);
//		e.setTelephone("0000000000");
//		etudiantRepository.save(e);
//		return "Etudiant updated";
//	}

	@PutMapping("/updateStudent/{id}")
	public String updateStudent(@RequestBody Etudiant etudiant, @PathVariable int id)
	{
		Etudiant e1 = etudiantRepository.getReferenceById(id);

		if (!e1.getNom().equals(etudiant.getNom()) && etudiant.getNom() != null)
		{
			e1.setNom(etudiant.getNom());
		}

		if (!e1.getPrenom().equals(etudiant.getPrenom()) && etudiant.getPrenom() != null)
		{
			e1.setPrenom(etudiant.getPrenom());
		}

		if (!e1.getEmail().equals(etudiant.getEmail()) && etudiant.getEmail() != null)
		{
			e1.setEmail(etudiant.getEmail());
		}

		if (!e1.getTelephone().equals(etudiant.getTelephone()) && etudiant.getTelephone() != null)
		{
			e1.setTelephone(etudiant.getTelephone());
		}

		if (e1.getAnneeEtude() != etudiant.getAnneeEtude() && etudiant.getAnneeEtude() != 0)
		{
			e1.setAnneeEtude(etudiant.getAnneeEtude());
		}

		etudiantRepository.save(e1);
		return "Etudiant : " + e1 + " updated";
	}
	
	
	@PutMapping("/updateStudentWithSchool/{idEtudiant}/{idEcole}")
	public String updateStudentWithSchool(@RequestBody Etudiant etudiant, @PathVariable int idEtudiant, @PathVariable int idEcole)
	{
		Ecole ecole = ecoleRepository.getReferenceById(idEcole);
		etudiant.setEcole(ecole);

		etudiantRepository.save(etudiant);
		return "Etudiant : " + etudiant + " updated";
	}

//	@GetMapping("/deleteEtudiant/{id}")
//	public String deleteEtudiant(@PathVariable("id") int id) {
//		etudiantRepository.deleteById(id);
//		return "Etudiant deleted";
//	}

	@DeleteMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("id") int id)
	{
		etudiantRepository.deleteById(id);
		return "student deleted";
	}
	
	@GetMapping("/listStudentsBySchool/{idEcole}")
	public ResponseEntity<List<Etudiant>> listStudentsBySchool(@PathVariable int idEcole) {
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findByIdEcole(idEcole), HttpStatus.OK);
	}
	
	@GetMapping("/studentsInLyon")
	public ResponseEntity<List<Etudiant>> getAllStudentsInLyon()
	{
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findByVilleLyon(), HttpStatus.OK);
	}
	
	@GetMapping("/studentsByProf")
	public ResponseEntity<List<Etudiant>> getAllStudentsByProf(@RequestParam("id") int id)
	{
		return new ResponseEntity<List<Etudiant>>(etudiantRepository.findByProf(id), HttpStatus.OK);
	}

}
