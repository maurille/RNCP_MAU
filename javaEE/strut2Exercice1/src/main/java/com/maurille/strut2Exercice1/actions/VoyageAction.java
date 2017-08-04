package com.maurille.strut2Exercice1.actions;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ApplicationAware;

import com.maurille.strut2Exercice1.DAO.GenericDAO;
import com.maurille.strut2Exercice1.metier.Agence;
import com.maurille.strut2Exercice1.metier.Voyage;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VoyageAction extends ActionSupport implements ApplicationAware, ModelDriven<Voyage> {
	
	
	private GenericDAO<Voyage> voyageDAO;
	private GenericDAO<Agence> agenceDAO;
	

	Logger log = LogManager.getLogger(VoyageAction.class); 
	
	private List<Voyage> voyages;// je crée une liste de voyage
	
	public List<Voyage> getVoyages() {
		log.info("appel de getVoyage()");
		if(voyages == null) {
			voyages = voyageDAO.findAll();
			// pour chaque voyage on recupere l'agence voyage associé
			for(Voyage v : voyages) {
				v.setAgence(agenceDAO.findByCle(v.getAgenceId()));
			}
		}
		return voyages;
	}
	
private List<Agence> agences; // creation liste d'agences
	
	public List<Agence> getAgences() {
		log.info("appel de getAgence()");
		if(voyages == null) {
			agences = agenceDAO.findAll();
		}
		return agences;
	}
	
//*******************utilisation de Model Driven***************	
		private Voyage model;
	
	// cest cette méthode qui nous permettra de répondre à la requette de la page JSP
		public String listeVoyage() {
			log.info(" appel de listeVoyage() ");

			return SUCCESS;
		}
		
//*****************edition d'un voyage*************************
	
		public String editerVoyage() {
			Voyage m = getModel();
			Voyage v = voyageDAO.findByCle(this.getModel().getId());
			if(v!=null) {
				m.setLibelle(v.getLibelle());
				m.setDestination(v.getDestination());
				m.setPrix(v.getPrix());
				m.setAgenceId(v.getAgenceId());
				m.setAgenceId(v.getAgenceId());
				return SUCCESS;
			}
			else {
				return ERROR;
			}
				}
		
//*****************création d'un voyage***************************		
		public String creerVoyage() {
			Voyage m = getModel();
				m.setId(0);
				m.setLibelle("votre libelle");
				m.setDestination("ville et/ou pays");
				m.setPrix(0.0);
				m.setAgenceId(1);
				m.setPasseport(false);
				return SUCCESS;

		}
		
//*****************sauvegarde d'un voyage************************	
		
public String sauverVoyage() {
			log.info("appel de sauverVoyage();");
			Voyage m = getModel();
			// on esssaie derecupérer le film si il existe dans la BD
//			Voyage f = voyageDAO.findByCle(m.getId());	
//			if ()
			voyageDAO.save(m);
			return SUCCESS;	
		}
		
//******************supprimer un voyage***************************

public String deleteVoyage() {
	voyageDAO.delete(getModel().getId());
	return SUCCESS;
	
}
		
	@Override
	public Voyage getModel() {
		// TODO Auto-generated method stub
		log.info("appel de getModel();");
		if(model == null)
			model = new Voyage();// je crée un voyage vide
		return model;
		
	}

	@Override
	public void setApplication(Map<String, Object> ctx) {
		// TODO Auto-generated method stub
		this.voyageDAO = (GenericDAO<Voyage>) ctx.get("voyageDAO");
		this.agenceDAO = (GenericDAO<Agence>) ctx.get("agenceDAO");
	}



}
