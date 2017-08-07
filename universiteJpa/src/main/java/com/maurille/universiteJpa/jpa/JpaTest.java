package com.maurille.universiteJpa.jpa;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.maurille.universiteJpa.beans.Cours;
import com.maurille.universiteJpa.beans.Etudiant;
import com.maurille.universiteJpa.beans.Matiere;
import com.maurille.universiteJpa.beans.Professeur;

public class JpaTest {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("testHibernate");
        Scanner input = new Scanner(System.in);

        input.nextLine();
        System.out.println("--------------------------------------");
		test1(emf);

        input.nextLine();
		System.out.println("--------------------------------------");
		test2(emf);

        input.nextLine();
		System.out.println("--------------------------------------");		

	    emf.close();
		System.out.println("done...");
	}




	public static void test1(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------
		em.persist(new Matiere(0,"algorithme"));
		em.persist(new Matiere(0,"programmation"));
		em.persist(new Matiere(0,"base de donnée"));
		em.persist(new Matiere(0,"graphes"));
		
		em.persist(new Professeur(0, "Genger", "marc", 4000.0));
		em.persist(new Professeur(0, "Bac", "Alexendra", 4000.0));
		em.persist(new Professeur(0, "Prosperi", "Serges", 4000.0));
		
		
		//String[] sujets = {"algorithme", "programmation", "graphes", "base de donnée"};
		//String[] liaison = {"a", "à la", "de"};
		//String[] action = {"introduction à la", "travaux pratique", "projet", "cours avancé"};

		Random rd = new Random();
		/*for (int i = 0; i < 10; i++) {
			String libelle = action[rd.nextInt(action.length)]	+
						" " + liaison[rd.nextInt(liaison.length)] +
						" " + sujets[rd.nextInt(sujets.length)] ;
			Cours c = new Cours(0, libelle, new Date(), new Date(), rd.nextInt(10) + 10);
			c.setProfesseur(em.find(Professeur.class, rd.nextInt(3) + 1));
			c.setMatiere(em.find(Matiere.class, rd.nextInt(4) + 1));
			// sauvegarde du cours
			em.persist(c);
		}*/
			
		Cours[] cours = new Cours[10];
		cours[0] = new Cours(0, "introduction à l'algorithme ", new Date(118,rd.nextInt(6),8) , new Date(118,rd.nextInt(6),8+5) ,  rd.nextInt(10) + 10 );
		cours[1] = new Cours(0, " travaux pratique base de données",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		cours[2] = new Cours(0, "projet programation",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		cours[3] = new Cours(0, "projet base de données",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		cours[4] = new Cours(0, "cours avancé base de données",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		cours[5] = new Cours(0, "introductiob graphes",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		cours[6] = new Cours(0, "cours avancée algorithme",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		cours[7] = new Cours(0, "travaux pratique graphes",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		cours[8] = new Cours(0, "projet graphes",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		cours[9] = new Cours(0, "introduction graphes",new Date(118,rd.nextInt(6),8) ,  new Date(118,rd.nextInt(6),8+5),  rd.nextInt(10) + 10 );
		
		for (Cours c : cours) {
			c.setMatiere(em.find(Matiere.class, rd.nextInt(4) + 1));
			c.setProfesseur(em.find(Professeur.class, rd.nextInt(3)+1));
			em.persist(c);
		}
		
		String[] noms = {"bob1", "bob2", "bob3", "bob4", "bob5"};
		String[] prenoms = {"sia", "saches", "Lio", "finidi", "Macro","jean"};
		String[] mails = {"yahoo.fr", "orange.fr", "gmail.com","univMLV"};
		for (int i = 0; i < 100; i++) {
			String nom = noms[rd.nextInt(noms.length)];	
			String prenom = prenoms[rd.nextInt(prenoms.length)];	
			String mail = nom + prenom	+"@"+
					mails[rd.nextInt(mails.length)];
						
			Etudiant e = new Etudiant(0, nom , prenom , mail);
			//e.setCours(em.find(Cours.class, rd.nextInt(9) + 1));

			for (Cours c :  cours ) {
				if (rd.nextDouble() < 0.25)
					c.getEtudiants().add(e);
			}
			em.persist(e);}
		
		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}


	public static void test2(EntityManagerFactory emf)
	{
		// on recupere un entityManager
		EntityManager em = emf.createEntityManager();
		// et une transaction
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//----------------------------------------------------

		
		TypedQuery<Etudiant> queryEtudiant = em.createQuery("select DISTINCT(e) from Etudiant"
				+ " as e join e.cours as c where c.dateDebut > :debut",
				Etudiant.class);
		queryEtudiant.setParameter("debut", new Date(118, 5,6));
		
		List<Etudiant> data = queryEtudiant.getResultList();
		for (Etudiant e : data) {
			System.out.println(e);
		}
		
		System.out.println("----------------------------");
		
		
		Query queryCours = em.createQuery("select c.libelle, COUNT(et.id)  from Cours as c "
				+ " join c.etudiants as et GROUP BY c");
		
		List<Object[]> data1 = queryCours.getResultList();
		for (Object[] row : data1) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println("----------------------------");
		
		Query queryCour = em.createQuery("select c.libelle, COUNT(et.id) * 100.00 / capaciteMax  from Cours as c "
				+ " join c.etudiants as et GROUP BY c");
		
		data1 = queryCour.getResultList();
		for (Object[] row : data1) {
			System.out.println(Arrays.toString(row));
		}
		
		/*System.out.println("----------------------------");
		
		Query q1 = em.createQuery("select m.libelle, COUNT(distinct et.id) from Matiere as m"
				+ "join m.cours as c"
				+ " join c.cours as et"
				+ " GROUP BY m.libelle");
		
		data1 = q1.getResultList();
		for (Object[] row : data1) {
			System.out.println(Arrays.toString(row));
		}*/

		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
