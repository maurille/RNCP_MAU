package com.maurille.jpaCms.jpa;

import java.time.LocalDate;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.maurille.jpaCms.beans.DocumentPdf;
import com.maurille.jpaCms.beans.Gallerie;
import com.maurille.jpaCms.beans.Tag;


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

		
		Tag[] tags = new Tag[5];
		tags[0] = new Tag(0,"tag1");
		tags[1] = new Tag(0,"tag1");
		tags[2] = new Tag(0,"tag1");
		tags[3] = new Tag(0,"tag1");
		tags[4] = new Tag(0,"tag1");
		
		for (Tag t : tags)
			em.persist(t);
		
		em.persist(new Gallerie(0, "gallerie", "Centre Pompidou"));
		em.persist(new Gallerie(0, "gallerie", " gallerie Emmanuel Hervé"));
		em.persist(new Gallerie(0, "gallerie", "Gallerie crèvecoeur"));
		em.persist(new Gallerie(0, "gallerie", "Gallerie Lara Vincy"));
		
		
		
		//em.persist(new DocumentPdf(0, "pdf", ""));
	
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
		
	
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
