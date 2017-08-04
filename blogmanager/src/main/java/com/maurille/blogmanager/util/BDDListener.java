package com.maurille.blogmanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.maurille.blogmanager.dao.GenericDAO;
import com.maurille.blogmanager.metier.Auteur;
import com.maurille.blogmanager.metier.Post;

public class BDDListener implements ServletContextListener {

	private Logger log = LogManager.getLogger(BDDListener.class);
	
    public BDDListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("initialisation connection base");
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/blogmanager",
					"root",
					"");
		
			GenericDAO<Post> postDAO = 
					new GenericDAO.Builder<Post>(Post.class,
													connection,
													"id")
											.build();
			sce.getServletContext().setAttribute("postDAO", postDAO);
			
			
			GenericDAO<Auteur> auteurDAO =
					new GenericDAO.Builder<Auteur>(Auteur.class,
												   connection,
												   "id")
								  .build();
			sce.getServletContext().setAttribute("auteurDAO", auteurDAO);
			
			
			log.info("initialisation DAO terminée");
			
		} catch (ClassNotFoundException e) {e.printStackTrace();}
    	catch (SQLException e) {e.printStackTrace();}
    	
    }
	
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

  
}
