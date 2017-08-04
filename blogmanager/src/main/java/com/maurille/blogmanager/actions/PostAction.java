package com.maurille.blogmanager.actions;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ApplicationAware;
import com.maurille.blogmanager.dao.GenericDAO;
import com.maurille.blogmanager.metier.Auteur;
import com.maurille.blogmanager.metier.Post;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PostAction extends ActionSupport implements ModelDriven<Post>, ApplicationAware	{
	
private Logger log = LogManager.getLogger(PostAction.class); 
	
	private GenericDAO<Post> postDAO;
	private GenericDAO<Auteur> auteurDAO;
	
	@Override
	public void setApplication(Map<String, Object> ctx) {
		postDAO = (GenericDAO<Post>)ctx.get("postDAO");
		auteurDAO = (GenericDAO<Auteur>)ctx.get("auteurDAO");
	}
	
	private Post model;
	@Override
	public Post getModel() {
		if(model == null)
			model = new Post();
		return model;
	}

	
	private List<Post> posts;
	public List<Post> getPosts() {
		if (posts == null) {
			posts = postDAO.findAll();
			for (Post p : posts) {
				// je recupere l'objet auteur associé à mon
				// Post, et je l'associe a mon objet post
				p.setAuteur(auteurDAO.findByCle(p.getAuteurId()));
			}
		}
		log.info("appel de getPost : nb posts " + posts.size());
		return posts;
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
	
	
	
	public String editPost() {
		Post m = getModel();
		Post p = postDAO.findByCle(m.getId());
		if (p == null) {
			return ERROR;
		}
		m.copyFrom(p);
		return SUCCESS;
	}
	
	public String createPost() {
		Post m = getModel();
		m.setId(0);
		m.setTitre("");
		m.setCorps("");
		LocalDate today = LocalDate.now();
		LocalDate inOneWeek = today.plusDays(7);
		m.setDateCreation(Date.from(
				today.atStartOfDay(
						ZoneId.systemDefault()
						).toInstant()));
		m.setDateEdition(Date.from(
				inOneWeek.atStartOfDay(
						ZoneId.systemDefault()
						).toInstant()));
		m.setAuteurId(1);
		return SUCCESS;
	}
	
	public String savePost() {
		
		Post p = getModel();
		log.info("appel de sauverPost() avec : " + p);
		postDAO.save(p);
		return SUCCESS;	
	}
	
	public String deletePost() {
		postDAO.delete(getModel().getId());
		return SUCCESS;
	}
}
