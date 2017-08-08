package com.maurille.jpaCms.beans;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @NoArgsConstructor @ToString(callSuper=true,exclude= {"images"})
public class Gallerie extends Content {

	private String titre;
	@OneToMany(mappedBy="gallerie", cascade=CascadeType.PERSIST)
	private Set<Image> images;
	

	public Gallerie(int id, String nom, String titre) {
		super(id, nom);
		this.titre = titre;
	}
	
	public Set<Image> getImages() {
		if (images == null) images = new HashSet<>();
		return images;}

}
