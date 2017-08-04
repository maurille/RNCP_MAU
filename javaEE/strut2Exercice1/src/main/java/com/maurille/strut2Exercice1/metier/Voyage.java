package com.maurille.strut2Exercice1.metier;

public class Voyage {
	private int id;
	private String libelle;
	private String destination;
	private double prix;
	private int agenceId;
	private boolean passeport;
	private Agence agence;
	
	public Voyage() {};
	
	public Voyage(int id, String libelle, String destination, double prix, String agence, boolean passeport) {
		this.id = id;
		this.libelle = libelle;
		this.destination = destination;
		this.prix = prix;
		this.agenceId = agenceId;
		this.passeport = passeport;
		this.agence = null;
	}



	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String getLibelle() {return libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	public double getPrix() {return prix;}
	public void setPrix(double prix) {this.prix = prix;}
	public int getAgenceId() {return agenceId;}
	public void setAgenceId(int agenceId) {this.agenceId = agenceId;}
	public boolean isPasseport() {return passeport;}
	public void setPasseport(boolean passeport) {this.passeport = passeport;}
	public String getDestination() {return destination;}
	public void setDestination(String destination) {this.destination = destination;}
	public Agence getAgence() {return agence;}
	public void setAgence(Agence agence) {this.agence = agence;}

	@Override
	public String toString() {
		return "Voyage [id=" + id + ", libelle=" + libelle + ", destination=" + destination + ", prix=" + prix
				+ ", agenceId=" + agenceId + ", passeport=" + passeport + "]";
	}
	

	
}
