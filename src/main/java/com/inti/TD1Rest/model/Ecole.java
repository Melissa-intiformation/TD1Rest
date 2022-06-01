package com.inti.TD1Rest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Ecole
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private String adresse;
	private String cp;
	private @NonNull String ville;

	@OneToMany(mappedBy = "ecole")
	@JsonIgnore
	private List<Etudiant> listeEtudiant;

	@ManyToMany
	@JoinTable(name = "Ecole_Professeur", joinColumns = @JoinColumn(name = "idEcole"), inverseJoinColumns = @JoinColumn(name = "idProf"))
	@JsonIgnore
	private List<Professeur> listeProfesseur;

	
	@Override
	public String toString()
	{
		return "Ecole [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", cp=" + cp + ", ville=" + ville + "]";
	}



	public Ecole(@NonNull String nom, String adresse, String cp, @NonNull String ville)
	{
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
	}

}
