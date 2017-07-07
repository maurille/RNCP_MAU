package com.mau.exerciceJava5.metier;

public class Rectangle extends Figure {
	private int longueur ;
	private int largeur;
	
	
	public Rectangle(String styleDuBord, String styleDuCentre, int longueur, int largeur) {
		super(styleDuBord, styleDuCentre);
		this.longueur = longueur;
		this.largeur = largeur;
	}


	public int getLongueur() {return longueur;}


	public void setLongueur(int longueur) {this.longueur = longueur;}


	public int getLargeur() {return largeur;}


	public void setLargeur(int largeur) {this.largeur = largeur;}


	@Override
	public String toString() {
		return "Rectangle [longueur=" + longueur + ", largeur=" + largeur + ", getStyleDuBord()=" + getStyleDuBord()
				+ ", getStyleDuCentre()=" + getStyleDuCentre() + "]";
	}
	

	
}
