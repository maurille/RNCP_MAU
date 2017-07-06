package exercice3_objet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exercice3_objet.metier.Article;

public class Program {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		Article A1 = new Article(2, " ", " ", " ", -2.0 );
		System.out.println(A1.toString());
		
		File f = new File("nomAuteurParam.txt");
		Scanner reader = new Scanner(f);
		String nomAuteur = reader.nextLine();
		reader.close();
		System.out.println("nom auteur  defaut = " + nomAuteur);

	}

}
