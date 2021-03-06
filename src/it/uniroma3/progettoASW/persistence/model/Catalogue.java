package it.uniroma3.progettoASW.persistence.model;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Catalogue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar lastUpdate;
	@Column(unique = true, nullable = false)
	private String genre;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "catalog_id")
	private List<Movie> movies;
	
	public Catalogue(){}

	public Catalogue(Calendar lastUpdate, String genre) {
		this.lastUpdate = lastUpdate;
		this.setGenre(genre);
		this.movies = new LinkedList<Movie>();
	}

	public void addMovie(Movie m){
		List<Movie> l= this.getMovies();
		l.add(m);
		this.setMovies(l);
	}

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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre.toLowerCase();
	}
	
}