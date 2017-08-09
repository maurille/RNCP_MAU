package com.maurille.jpaCms.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.maurille.jpaCms.beans.Content;
import com.maurille.jpaCms.beans.DocumentPdf;
import com.maurille.jpaCms.beans.Gallerie;
import com.maurille.jpaCms.beans.Image;
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
		tags[1] = new Tag(0,"tag2");
		tags[2] = new Tag(0,"tag3");
		tags[3] = new Tag(0,"tag4");
		tags[4] = new Tag(0,"tag5");
		
		for (Tag t : tags)
			em.persist(t);

		
		
		Gallerie[] galleries = new Gallerie[4];
		galleries[0] = new Gallerie(0, "gallerie", "Centre Pompidou");
		galleries[1] = new Gallerie(0, "gallerie", "gallerie Emmanuel Hervé");
		galleries[2] = new Gallerie(0, "gallerie", "Gallerie crèvecoeur");
		galleries[3] = new Gallerie(0, "gallerie", "Gallerie Lara Vincy");
		
		for (Gallerie g : galleries)
			em.persist(g);
		
		

		DocumentPdf[] pdf = new DocumentPdf[6];
		pdf[0] = new DocumentPdf(0,"document", "Nu au plateau de sculpteur", "Pablo Picaso");
		pdf[1] = new DocumentPdf(0,"document", "Iris", "Vincent van Gogh");
		pdf[2] = new DocumentPdf(0,"document", "Le Printemps", "Edouard Manet");
		pdf[3] = new DocumentPdf(0,"document", "Trois études de Lucian Freud", "Francis Bacon");
		pdf[4] = new DocumentPdf(0,"document", "Quand te maries-tu ? ", "Paul Gauguin");
		pdf[5] = new DocumentPdf(0,"document", "Portrait d'Adèle Bloch-Bauer II ", "Gustave Klimt");
		
		for (DocumentPdf d : pdf)
			em.persist(d);
		

		
String[] file = {"Les Femmes d'Alger ", "Le Rêve", "Portrait du Dr. Gachet", "Nu au plateau de sculpteur"};
String[] type = {"photo", "illustration", "clipart", "toile", "vecteur"};
		
		Random rd = new Random();
		for (int i = 0; i < 90; i++) {
			String file1 = file[rd.nextInt(file.length)];
			String type1 = type[rd.nextInt(type.length)];
			Image im = new Image(0,"image" , file1, type1 );
			im.setGallerie(em.find(Gallerie.class, rd.nextInt(4) + 1));

			/*for (Gallerie g : galleries) {
				if (rd.nextBoolean())
					g.getImages().add(im);
			}*/
			
			em.persist(im);

		}
		
		List<Content> data = em.createQuery("from Content", Content.class).getResultList();
		for (Content c : data) {
			for(Tag t : tags) {
				if(rd.nextBoolean())
					c.getTags().add(t);
			}
		}
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
		
		System.out.println("--------------Un--------------");
		TypedQuery<Image> queryImage = em.createQuery("select DISTINCT(i) from Image"
				+ " as i join i.tags as t where t.libelle = :etiquette",
				Image.class);
		queryImage.setParameter("etiquette", "tag1");
		
		List<Image> data = queryImage.getResultList();
		for (Image i : data) {
			System.out.println(i);
		}
		
		System.out.println("--------------Deux--------------");
		
		
		Query queryGallerie = em.createQuery("select g.titre, COUNT(et.id)  from Gallerie as g "
				+ " join g.images as et GROUP BY g.titre");
		
		List<Object[]> data1 = queryGallerie.getResultList();
		for (Object[] row : data1) {
			System.out.println(Arrays.toString(row));
		}
		
System.out.println("--------------Trois--------------");
		
		TypedQuery<Content> queryContent = em.createQuery("select c from Content"
				+ " as c  JOIN c.tags as t1"
					+ " Join c.tags as t2"
				+ " where t1.libelle = :etiquette1 AND t2.libelle = :etiquette2",
				Content.class);
		queryContent.setParameter("etiquette1", "tag1");
		queryContent.setParameter("etiquette2", "tag2");
		
		List<Content> dat = queryContent.getResultList();
		for (Content c : dat) {
			System.out.println(c);
		}
		
		
		System.out.println("--------------Quatre--------------");
		
		Query queryTag = em.createQuery("select t.libelle, COUNT(c.id)  from Tag as t join t.contents as c "
				+ "  GROUP BY t");
		
		List<Object[]> data2 = queryTag.getResultList();
		for (Object[] row : data2) {
			System.out.println(Arrays.toString(row));
		}
		
		System.out.println("--------------cinq--------------");
		
		TypedQuery<Content> qs =em.createQuery("select c from Content as c where c.dateEdition>:date", Content.class);
		qs.setParameter("date", LocalDateTime.now().minusSeconds(10));
		//qs.setParameter("date", LocalDateTime.now());
		List<Content> dat1 = queryContent.getResultList();
		for (Content c : dat1) {
			System.out.println(c);
		}
		
		
System.out.println("--------------six--------------");
		

		
		//----------------------------------------------------
		tx.commit();
		em.close();
	}

}
