package it.uniroma3.progettoASW.controller;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.persistence.facade.CatalogueFacade;
import it.uniroma3.progettoASW.persistence.model.Catalogue;
import it.uniroma3.progettoASW.persistence.model.Movie;

@ManagedBean
public class CatalogueController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Calendar lastUpdate;
	private Genre genre;
	private List<Movie> movies;
	private Catalogue catalogue;
	
	@EJB(name="catalogueFacade")
	private CatalogueFacade cataloqueFacade;
	
	public String createCatalogue () {
		this.catalogue=this.cataloqueFacade.addCatalog(this.genre);
		return "catalogue";
	}
	
	public String findCatalogue() {
		this.catalogue=this.cataloqueFacade.getCatalog(this.genre);
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
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
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
	
	
	

}
