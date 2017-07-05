package exerciceA;

import java.util.Scanner;

public class exoA {
	
	public static int fonctionA (double ...valeurs)
	{
		
		
		int compteur=0;
		for(double d  : valeurs) {
			

			if(d > 0)
				compteur++;
		}
			
		
		return compteur;
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double variable;
		variable = fonctionA(5, 1.2, 5, 5.2, 2.3, -2.5);

		System.out.println("le nombre de variables positif " +  variable);
	}

}
