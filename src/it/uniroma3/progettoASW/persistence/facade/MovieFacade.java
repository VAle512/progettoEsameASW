package it.uniroma3.progettoASW.persistence.facade;

import java.util.GregorianCalendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.persistence.model.Catalogue;
import it.uniroma3.progettoASW.persistence.model.Movie;

@Stateless(name="movieFacade")
public class MovieFacade {
	
	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;

	public Movie addMovie(String title, Integer year, String director, Integer length, Genre genre) {
		Catalogue c = new CatalogueFacade().getCatalog(genre);
		Movie m = new Movie(title, year, director, length, c);
		c.addMovie(m);
		c.setLastUpdate(new GregorianCalendar());
		this.em.persist(m);
		this.em.merge(c);
		return m;
	}

	public Movie findMovie(String title) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Movie findMovieForGenre(Genre genre) {
		return null;
	}
	
}