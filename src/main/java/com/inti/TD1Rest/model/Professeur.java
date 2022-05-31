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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@ManyToMany
	@JoinTable( name="Ecole_Professeur",
	joinColumns = @JoinColumn(name= "idProf"),
	inverseJoinColumns = @JoinColumn(name= "idEcole"))
	@JsonIgnore
	private List<Ecole> listeEcole;
	
	@ManyToMany
	@JoinTable( name="Etudiant_Professeur",
				joinColumns = @JoinColumn(name= "idProf"),
				inverseJoinColumns = @JoinColumn(name= "idEtudiant"))
	@JsonIgnore
	private List<Etudiant> listeEtudiant;

	public Professeur(@NonNull String nom, @NonNull String prenom, double salaire)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.salaire = salaire;
	}
	
	
}
