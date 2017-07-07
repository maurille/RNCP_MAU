package com.mau.generiqueCollectionJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.mau.generiqueCollectionJava.metier.Tuple;



public class Program {

	public static void main(String[] args) {
	
		ArrayList tab1 = new ArrayList<>();
		tab1.add("bonour");
		tab1.add("hello");
		tab1.add("salam");
		tab1.add(100);
		
		System.out.println(tab1.size());
		System.out.println(tab1.get(2));
		
		for( Object o: tab1) {
			
			System.out.println(o);
		}
		
		System.out.println("-----------------------------");
		
		ArrayList<String> lundis = new ArrayList<String>();
		
		lundis.add("lundi");
		lundis.add("monday");
		lundis.add("montag");
		lundis.add("lunes");
		
		for( String str : lundis) {
			System.out.println(str + " " + str.length() );
			
		}
		
		
		System.out.println("-----------------------------");
		// l'objet à la position 2 sachant que ca commence à partir de zéro
		String chaine = lundis.get(2);
		System.out.println(chaine);
		
		System.out.println("-----------------------------");
		lundis.remove(2);
		for( String str : lundis) {
			System.out.println(str + " " + str.length() );
		}
			
		lundis.set(2, "satidégbé");
		for( String str : lundis) {
			System.out.println(str + " " + str.length() );
		}
		
		
		lundis.add(1, "gouzangbé");
		for( String str : lundis) {
			System.out.println(str + " " + str.length() );
		}
		
		
		java.util.List<String> liste = lundis;
	
		
		System.out.println("----------used Map-------------");
		
		Map<String, Double> dictionnaire = new HashMap<>();
		dictionnaire.put("Paris", 1000000.0);
		dictionnaire.put("Hambourg", 1000000.0);
		dictionnaire.put("Madrid", 3100000.0);
		dictionnaire.put("Tokyo", 1300000.0);
		
		System.out.println( dictionnaire.get("Madrid"));
		System.out.println(  );
		
		for(String cle : dictionnaire.keySet()) {
			System.out.println(cle + "-->" + dictionnaire.get(cle));
		}
		
		System.out.println(  );
		System.out.println(" ------les généricités---------");
		
		Tuple<String, Double> couple1 = new Tuple<String, Double>("Paris", 30.0);
		
		if(couple1.getValue2() > 30.0)
			System.out.println("il fait chaud");
		else
			System.out.println(" ça va ...");
		
		ArrayList< Tuple<String, Double> > meteoVilles = new ArrayList<>();
		
		meteoVilles.add(new Tuple<String, Double>("Paris", 30.0));
		meteoVilles.add(new Tuple<String, Double>("Madrid", 32.0));
		meteoVilles.add(new Tuple<String, Double>("Lodon", 31.0));
		meteoVilles.add(new Tuple<String, Double>("Marseille", 30.0));
		meteoVilles.add(new Tuple<String, Double>("New york", 30.0));
		meteoVilles.add(new Tuple<String, Double>("florence", 23.0));
		
		
		meteoVilles.stream().forEach(t -> System.out.println(t));
		
		meteoVilles.stream()
						.filter(t ->t.getValue2() < 30.)
						.forEach(t -> System.out.println(t) );
		
		
		Collections.sort(meteoVilles);
		System.out.println("-----------------------------------");
		meteoVilles.stream().forEach(t -> System.out.println(t));
		
		
							
						}
	
	  
		
		
		
	

}
