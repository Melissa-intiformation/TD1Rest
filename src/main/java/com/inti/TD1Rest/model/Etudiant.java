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
import javax.persistence.OneToOne;
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
public class Etudiant
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private @NonNull String nom;
	private @NonNull String prenom;
	private String email;
	private String telephone;
	private @NonNull int anneeEtude;
	
	@ManyToOne
	@JoinColumn(name = "idEcole")
	private Ecole ecole;
	
	@ManyToMany
	@JoinTable( name="Etudiant_Professeur",
				joinColumns = @JoinColumn(name= "idEtudiant"),
				inverseJoinColumns = @JoinColumn(name= "idProf"))
	@JsonIgnore
	private List<Professeur> listeProf;

	@Override
	public String toString()
	{
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", telephone="
				+ telephone + ", anneeEtude=" + anneeEtude + "]";
	}

	public Etudiant(@NonNull String nom, @NonNull String prenom, String email, String telephone,
			@NonNull int anneeEtude)
	{
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.anneeEtude = anneeEtude;
	}
	
	
}
