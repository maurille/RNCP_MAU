package com.mau.exercieceJava4.metier;

public  class Personne {
	private String nom;
	private String prenom;
	private String email;
	

	
	public Personne(String nom, String prenom, String email) {
		
		setNom(nom);
		setPrenom(prenom);
		setEmail(email);
		
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Personne [nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	
	
	public void contacter(){
		
		System.out.println("je contacte une personne");
	}

	
	
	

}
