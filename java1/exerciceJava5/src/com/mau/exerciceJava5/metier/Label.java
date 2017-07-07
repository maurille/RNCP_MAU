package com.mau.exerciceJava5.metier;

public class Label {
	private String texte;

	public Label(String texte) {
		this.texte = texte;
	}

	public String getTexte() {return texte;}

	public void setTexte(String texte) {this.texte = texte;}

	@Override
	public String toString() {
		return "Label [texte=" + texte + "]";
	}
	
	
	

}
