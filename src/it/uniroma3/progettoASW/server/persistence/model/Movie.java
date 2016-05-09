package it.uniroma3.progettoASW.server.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String title;
	private Integer year;
	private String director;
	private Integer length;
	@ManyToOne
	private Catalogue catalogue;
	
	public Movie(){}

	public Movie(String title, Integer year, String director, Integer length, Catalogue catalogue) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.length = length;
		this.catalogue=catalogue;
	}

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

	public Catalogue getCatalog() {
		return catalogue;
	}

	public void setCatalog(Catalogue catalogue) {
		this.catalogue = catalogue;
	}
		
}