package com.maurille.strut2Exercice1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.maurille.strut2Exercice1.DAO.GenericDAO;
import com.maurille.strut2Exercice1.metier.Agence;
import com.maurille.strut2Exercice1.metier.Voyage;



/**
 * Application Lifecycle Listener implementation class BDDListener
 *
 */
public class BDDListener implements ServletContextListener {


    public BDDListener() {
        // TODO Auto-generated constructor stub
    }
    
    

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("initialisation connection base");
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection connection = DriverManager.getConnection(
    				"jdbc:mysql://localhost:3306/agencevoyage",
    				"root",
    				"");
    		/*
    		// instanciation du dao des produits
    		ProduitDAO produitDAO = new ProduitDAO(connection);
    		// mettre celui-ci a disposition des servlets (et autre) de la webapp
    		sce.getServletContext().setAttribute("produitDAO", produitDAO);
    		*/
    		
    		GenericDAO<Voyage> voyageDAO = 
    			new GenericDAO.Builder<Voyage>(Voyage.class,connection,"id").build();
    			sce.getServletContext().setAttribute("voyageDAO", voyageDAO);
    			
    			
    			GenericDAO<Agence> agenceDAO = 
    	    			new GenericDAO.Builder<Agence>(Agence.class,connection,"id").build();
    	    			sce.getServletContext().setAttribute("agenceDAO", agenceDAO);
    		
    			System.out.println("initialisation DAO terminÃ©e");
    		
    	} catch (ClassNotFoundException e) {e.printStackTrace();}
    	catch (SQLException e) {e.printStackTrace();}
    }
	
}
