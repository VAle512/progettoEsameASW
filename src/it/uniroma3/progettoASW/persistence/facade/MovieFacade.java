package it.uniroma3.progettoASW.persistence.facade;

import java.util.GregorianCalendar;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.persistence.model.Catalog;
import it.uniroma3.progettoASW.persistence.model.Movie;
import it.uniroma3.progettoASW.persistence.util.HibernateUtil;

public class MovieFacade {
	
	private Session session;
	
	public MovieFacade(){
		this.session = HibernateUtil.getSession();
	}

	public Movie addMovie(String title, Integer year, String director, Integer length, Genre genre) {
		Catalog c = new CatalogFacade().getCatalog(genre);
		Movie m = new Movie(title, year, director, length, c);
		c.addMovie(m);
		c.setLastUpdate(new GregorianCalendar());
		Transaction tx = this.session.beginTransaction();
		this.session.persist(m);
		this.session.merge(c);
		tx.commit();
		return m;
	}
	
}