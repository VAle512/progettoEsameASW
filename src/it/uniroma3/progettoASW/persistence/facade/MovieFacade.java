package it.uniroma3.progettoASW.persistence.facade;

import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.persistence.exceptions.MovieNotFoundException;
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