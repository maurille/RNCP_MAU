package com.maurille.universiteJpa.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString( exclude= {"cours"})
public class Matiere {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	@OneToMany(mappedBy="matiere", cascade=CascadeType.PERSIST)
	private Set<Cours> cours;
	
	public Matiere(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}
	
	
	
	public Set<Cours> getCours() {
		if(cours == null) cours = new HashSet<>();
		return cours;
	}
	
	
	

}
