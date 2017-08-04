package com.maurille.blogmanager.actions;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ApplicationAware;

import com.maurille.blogmanager.dao.GenericDAO;
import com.maurille.blogmanager.metier.Auteur;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AuteurAction extends ActionSupport implements ModelDriven<Auteur>, ApplicationAware{

	private Logger log = LogManager.getLogger(AuteurAction.class); 
	
	private GenericDAO<Auteur> auteurDAO;
	@Override
	public void setApplication(Map<String, Object> ctx) {
		// TODO Auto-generated method stub
		this.auteurDAO = (GenericDAO<Auteur>)ctx.get("auteurDAO");
	}
	
	private Auteur model;
	@Override
	public Auteur getModel() {
		if(model == null)
			model = new Auteur();
		return model;
	}
	
	private List<Auteur> auteurs;
	public List<Auteur> getAuteurs() {
		if (auteurs == null)
			auteurs = auteurDAO.findAll();
		return auteurs;
	}

	public String liste() {
		log.info("appel de Liste");
		return SUCCESS;
	}
	
	public String ajouter() {
		Auteur a = getModel();
		a.setId(0);
		a.setNom("");
		a.setPrenom("");
		a.setEmail("email");
		
		return SUCCESS;
	}

}
