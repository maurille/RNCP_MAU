package com.mau.exercieceJava4.metier;

public class Client extends Personne {
	private double soldeCompte;
	private int noClient;
	
	
	public Client(String nom, String prenom, String email, double soldeCompte, int noClient) {
		super(nom, prenom, email);
		this.soldeCompte = soldeCompte;
		this.noClient = noClient;
	}


	public double getSoldeCompte() {return soldeCompte;}


	public void setSoldeCompte(double soldeCompte) {this.soldeCompte = soldeCompte;}


	public int getNoClient() {return noClient;}


	public void setNoClient(int noClient) {this.noClient = noClient;}


	@Override
	public String toString() {
		return super.toString() + "Client [soldeCompte="  + soldeCompte + ", noClient=" + noClient + "]";
	}

	public void contacter() {
		System.out.println("je contacte un client");
	}
	
	
	
	
	}
	

	


