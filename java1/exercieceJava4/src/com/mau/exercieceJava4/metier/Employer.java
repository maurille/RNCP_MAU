package com.mau.exercieceJava4.metier;

public class Employer extends Personne {
	private double salaire;
	private String poste;
	

	
	public Employer(String nom, String prenom, String email, double salaire, String poste) {
		super(nom, prenom, email);
		setSalaire(salaire);
		setPoste(poste);
	}
	
	
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}


	@Override
	public String toString() {
		return super.toString() + "Employer [salaire=" + salaire + ", poste=" + poste + "]";
	}
	
	public void contacter() {
		System.out.println("je contacte un employer");
	}
	
}
