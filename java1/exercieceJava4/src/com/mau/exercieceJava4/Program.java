package com.mau.exercieceJava4;

import com.mau.exercieceJava4.metier.Employer;
import com.mau.exercieceJava4.metier.Personne;

public class Program {

	public static void main(String[] args) {
		Personne p1= new Personne( "mau", "momo", "emoolkl");
		 System.out.println(p1.toString());
		p1.contacter();
		
		Employer E1 = new Employer("mau", "momo", "emoolkl",1550.0, "secretaire");
		System.out.println(E1.toString());
		E1.contacter();
		}

}
