package exercice3_objet.metier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Article {
	private int id;
	private String titre;
	private String corps;
	private static String nomAuteur;
	private double rating;
	
	public static final  int TITRE_LENGTH_MIN = 5;
	public static final int TITRE_LENGTH_MAX = 100;
	public static final int CORPS_LENGTH_MIN = 5;
	public static final int CORPS_LENGTH_MAX = 400;
	
	public static final double RATING_LENGTH_MIN = 0.0;
	public static final double RATING_LENGTH_MAX = 2.5;
	
	public static final int NOM_AUTEUR_LENGTH_MIN = 2;
	public static final int NOM_AUTEUR_LENGTH_MAX = 50;
	public static final String TITRE_DEFAULT = "lorem";
	public static final String CORPS_DEFAULT = "lorem ipsum";
	public static final String NOM_AUTEUR_DEFAULT;
	public static final double RATING_DEFAULT = 2.5;
	
	public static int  next_id = 1;
	
	
	
	static {
		String nomAuteur = "homer";
		try {
			File f = new File("nomAuteurParam.txt");
			Scanner reader = new Scanner(f);
			nomAuteur = reader.nextLine();
			reader.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}
		NOM_AUTEUR_DEFAULT = nomAuteur;
	}
	
	
	public Article() {
		this(next_id++ ,TITRE_DEFAULT,CORPS_DEFAULT ,NOM_AUTEUR_DEFAULT ,RATING_DEFAULT   );
	}
	
	public Article( String titre, String corps, String nomAuteur, double rating) {
		this(next_id++ ,TITRE_DEFAULT,CORPS_DEFAULT ,NOM_AUTEUR_DEFAULT ,RATING_DEFAULT   );
	}
	
	public Article(int id, String titre, String corps, String nomAuteur, double rating) {
		setId(id);
		setTitre(titre);
		setCorps(corps);
		setNomAuteur(nomAuteur);
		setRating(rating);
	}

	

	public int getId() {return id;}


	public void setId(int id) {this.id = id;}


	public String getTitre() {return titre;}


	public void setTitre(String titre) {
		if (titre == null) {
			this.titre = TITRE_DEFAULT;
		}
		else {
			if (titre.length() < TITRE_LENGTH_MIN || titre.length() > TITRE_LENGTH_MAX)
				this.titre = TITRE_DEFAULT;
			else
				this.titre = titre;			
		}
		
}


	public String getCorps() {return corps;}


	public void setCorps(String corps) {
		if (corps == null) {
			this.corps = CORPS_DEFAULT;
		}
		else {
			if (corps.length() < CORPS_LENGTH_MIN || corps.length() > CORPS_LENGTH_MAX)
				this.corps = CORPS_DEFAULT;
			else
				this.corps = corps;			
		}
	}


	public String getNomAuteur() {return nomAuteur;}


	public void setNomAuteur(String nomAuteur) {
		if (nomAuteur == null) {
			this.nomAuteur = CORPS_DEFAULT;
		}
		else {
			if (nomAuteur.length() < NOM_AUTEUR_LENGTH_MIN || nomAuteur.length() > NOM_AUTEUR_LENGTH_MAX)
				this.corps = NOM_AUTEUR_DEFAULT;
			else
				this.nomAuteur = nomAuteur;			
		}
	}


	public double getRating() {return rating;}

	public void setRating(double rating) {
		
	if (rating >= RATING_LENGTH_MIN && rating <= RATING_LENGTH_MAX)
		 this.rating = rating;
	else this.rating = RATING_DEFAULT; }


	@Override
	public String toString() {
		return "Article [id=" + id + ", titre=" + titre + ", corps=" + corps + ", nomAuteur=" + nomAuteur + ", rating="
				+ rating + "]";
	}
	
	

}
