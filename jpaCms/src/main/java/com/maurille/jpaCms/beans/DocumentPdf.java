package com.maurille.jpaCms.beans;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(callSuper=true)
public class DocumentPdf extends Content {
private String titre;
private String nomAuteur;
public DocumentPdf(int id, String nom, String titre,
		String nomAuteur) {
	super(id, nom);
	this.titre = titre;
	this.nomAuteur = nomAuteur;
}





}
