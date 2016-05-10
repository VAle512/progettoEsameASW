package it.uniroma3.progettoASW.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.*;

import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.persistence.facade.MovieFacade;
import it.uniroma3.progettoASW.persistence.model.Movie;

@ManagedBean
public class MovieController {
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String title;
	private Integer year;
	private String director;
	private Integer length;
	private Movie movie;
	private Genre genre; 
	private List<Movie> movies;
	
	@EJB(name="movieFacade")
	MovieFacade movieFacade;
	
	public String createMovie() {
		this.movie=movieFacade.addMovie(title, year, director, length, genre);
		return "movie";
		
	}
	
	
	//getters and setters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}


}
