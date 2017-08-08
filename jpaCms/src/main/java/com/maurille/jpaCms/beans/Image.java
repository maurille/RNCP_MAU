package com.maurille.jpaCms.beans;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(callSuper=true)
public class Image extends Content {
private String fileName;
private String typeImage;
@ManyToOne(cascade=CascadeType.PERSIST) 
private Gallerie gallerie;

public Image(int id, String nom, String fileName,
		String typeImage) {
	super(id, nom);
	this.fileName = fileName;
	this.typeImage = typeImage;
}



}
