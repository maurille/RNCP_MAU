package com.mau.exerciceJava5.metier;

public class Triangle extends Figure {
	private int cot�;

	public Triangle(String styleDuBord, String styleDuCentre, int cot�) {
		super(styleDuBord, styleDuCentre);
		setCot�(cot�);
	}

	public int getCot�() {return cot�;}

	public void setCot�(int cot�) {this.cot� = cot�;}
	

	@Override
	public String toString() {
		return "Triangle [cot�=" + cot� + ", getStyleDuBord()=" + getStyleDuBord() + ", getStyleDuCentre()="
				+ getStyleDuCentre() + "]";
	}


	

}
