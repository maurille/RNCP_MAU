package com.maurille.universiteJpa.beans;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Etudiant {

	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	@ManyToMany(mappedBy="etudiants")
	private Set<Cours> cours;

	
public Etudiant() {};	
public Etudiant(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getNom() {return nom;}

	public void setNom(String nom) {this.nom = nom;}

	public String getPrenom() {return prenom;}

	public void setPrenom(String prenom) {this.prenom = prenom;}

	public String getEmail() {return email;}

	public void setEmail(String email) {this.email = email;}
	

	public Set<Cours> getCours() {
		if(cours ==null) cours = new HashSet<>();
		return cours;
	}

	public void setCours(Set<Cours> cours) {
		this.cours = cours;
	}

	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}


}
