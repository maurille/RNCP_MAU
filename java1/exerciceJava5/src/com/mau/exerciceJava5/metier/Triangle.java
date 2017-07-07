package com.mau.exerciceJava5.metier;

public class Triangle extends Figure {
	private int coté;

	public Triangle(String styleDuBord, String styleDuCentre, int coté) {
		super(styleDuBord, styleDuCentre);
		setCoté(coté);
	}

	public int getCoté() {return coté;}

	public void setCoté(int coté) {this.coté = coté;}
	

	@Override
	public String toString() {
		return "Triangle [coté=" + coté + ", getStyleDuBord()=" + getStyleDuBord() + ", getStyleDuCentre()="
				+ getStyleDuCentre() + "]";
	}


	

}
