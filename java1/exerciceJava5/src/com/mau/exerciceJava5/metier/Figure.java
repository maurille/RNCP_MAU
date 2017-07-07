package com.mau.exerciceJava5.metier;

abstract class Figure {
	private String styleDuBord;
	private String styleDuCentre;
	
	
	
	public Figure(String styleDuBord, String styleDuCentre) {
	
		setStyleDuBord(styleDuBord); 
		setStyleDuCentre(styleDuCentre);
	
	}

	

	public String getStyleDuBord() {return styleDuBord;}

	public void setStyleDuBord(String styleDuBord) {this.styleDuBord = styleDuBord;}

	public String getStyleDuCentre() {return styleDuCentre;}

	public void setStyleDuCentre(String styleDuCentre) {this.styleDuCentre = styleDuCentre;}



	@Override
	public String toString() {
		return "Figure [styleDuBord=" + styleDuBord + ", styleDuCentre=" + styleDuCentre + "]";
	}
	
	
	
	

}
