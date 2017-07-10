package com.mau.intermediaireSwing.metier;

import java.util.function.Predicate;

public class Produit {
	
	
	
	
public static final  Predicate<Produit> ALL_CATEGORIE_FILTER 
											= p -> true;
public static final  Predicate<Produit> VIANDE_CATEGORIE_FILTER
								= p -> p.getCategorie().equals("viandes");
	
public static final  Predicate<Produit> FROMAGE_CATEGORIE_FILTER
								= p -> p.getCategorie().equals("fromage");
								
public static final  Predicate<Produit> CEREALE_CATEGORIE_FILTER
								= p -> p.getCategorie().equals("creales");
public static final  Predicate<Produit> LEGUMES_CATEGORIE_FILTER
								= p -> p.getCategorie().equals("legumes");
public static final  Predicate<Produit> DIVERS_CATEGORIE_FILTER
								= p -> p.getCategorie().equals("divers");
	
	private int id;
	private String nom;
	private double prix;
	private double poids;
	private String categorie;
	
	public Produit() {this(0, "", 0.0, 0.0, "divers") ;}
	
	public Produit(int id, String nom, double prix, double poids, String categorie) {
		super();
		setId(id);
		setNom(nom);
		setPrix(prix);
		setPoids(poids);
		setCategorie(categorie);
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {this.id = id;}
	public String getNom() {return nom;}
	public void setNom(String nom) {this.nom = nom;}
	public double getPrix() {return prix;}
	public void setPrix(double prix) {this.prix = prix;}
	public double getPoids() {return poids;}
	public void setPoids(double poids) {this.poids = poids;}

	public String getCategorie() {return categorie;}

	public void setCategorie(String categorie) {this.categorie = categorie;}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", poids=" + poids + ", categorie=" + categorie
				+ "]";
	}
	

	

}
