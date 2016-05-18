package it.uniroma3.progettoASW.persistence.facade;

import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.progettoASW.persistence.exceptions.CatalogueNotFoundException;
import it.uniroma3.progettoASW.persistence.exceptions.MovieNotFoundException;
import it.uniroma3.progettoASW.persistence.model.Catalogue;
import it.uniroma3.progettoASW.persistence.model.Movie;

@Stateless(name="movieFacade")
public class MovieFacade {
	
	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;

	@EJB(name="catalogueFacade")
	private CatalogueFacade cataloqueFacade;
	
	public Movie addMovie(String title, Integer year, String director, Integer length, String genre) {
		Catalogue c = null;
		try {
			c = this.cataloqueFacade.getCatalogue(genre);
		} catch (CatalogueNotFoundException e) {
			e.printStackTrace();
		}
		Movie m = new Movie(title, year, director, length, c);
		c.addMovie(m);
		c.setLastUpdate(new GregorianCalendar());
		this.em.merge(c);
		this.em.persist(m);
		return m;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovies(){
		Query q = this.em.createNamedQuery("SELECT m FROM Movie m");
		List<Movie> movies = q.getResultList();
		return movies;
	}
	
	public Movie findMovie(String title) throws MovieNotFoundException {
		List<Movie> movies = this.getAllMovies();
		for(Movie m : movies){
			if(m.getTitle().equals(title))
				return m;
		}
		throw new MovieNotFoundException();
	}
		
}