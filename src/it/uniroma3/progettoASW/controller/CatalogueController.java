package it.uniroma3.progettoASW.controller;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.progettoASW.persistence.exceptions.CatalogueNotFoundException;
import it.uniroma3.progettoASW.persistence.facade.CatalogueFacade;
import it.uniroma3.progettoASW.persistence.model.Catalogue;
import it.uniroma3.progettoASW.persistence.model.Movie;

@ManagedBean
public class CatalogueController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Calendar lastUpdate;
	private List<Movie> movies;
	private Catalogue catalogue;
	private String genre;
	
	@EJB(name="catalogueFacade")
	private CatalogueFacade cataloqueFacade;
	
	public String createCatalogue () {
		this.catalogue=this.cataloqueFacade.addCatalogue(this.genre);
		return "catalogue";
	}
	
	public String findCatalogue() {
		try {
			this.catalogue=this.cataloqueFacade.getCatalogue(this.genre.toLowerCase());
		} catch (CatalogueNotFoundException e) {
			e.printStackTrace();
		}
		return "catalogue";
	}
	
	
	// getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public Catalogue getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(Catalogue catalogue) {
		this.catalogue = catalogue;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
