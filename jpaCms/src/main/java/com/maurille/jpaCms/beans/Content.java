package com.maurille.jpaCms.beans;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import com.maurille.jpaCms.utils.Horodatable;
import com.maurille.jpaCms.utils.Horodateur;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@EntityListeners({Horodateur.class}) 
@Getter @Setter @NoArgsConstructor  @ToString(exclude= {"tags"})
public class Content implements Horodatable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private LocalDateTime dateCreation;
	private LocalDateTime dateEdition;
	@ManyToMany
	@JoinTable(name="Tagging",
			   joinColumns= {@JoinColumn(name="idContent")},
			   inverseJoinColumns= {@JoinColumn(name="idTag")})
	private Set<Tag> tags;
	
	
	public Set<Tag> getTags() {
		if (tags == null) tags = new HashSet<>();
		return tags;}


	public Content(int id, String nom) {
		this.id = id;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.dateEdition = dateEdition;
	}

}
