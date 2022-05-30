package com.inti.TD1Rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Professeur
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private @NonNull String prenom;
	private double salaire;
	
	@ManyToOne
	@JoinColumn(name = "idEcole")
	private Ecole ecole;
	
	@ManyToMany
	@JoinTable( name="Etudiant_Professeur",
				joinColumns = @JoinColumn(name= "idProf"),
				inverseJoinColumns = @JoinColumn(name= "idEtudiant"))
	private List<Etudiant> listeEtudiant;
	
}
