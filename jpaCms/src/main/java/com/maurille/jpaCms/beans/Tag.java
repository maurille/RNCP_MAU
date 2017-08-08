package com.maurille.jpaCms.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor  @ToString
public class Tag {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String libelle;
	@ManyToMany(mappedBy="tags")
	private Set<Content> contents;
	
	public Tag(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}
	public Set<Content> getContent() {
		if (contents == null) contents = new HashSet<>();
		return contents;
		
	}



}
