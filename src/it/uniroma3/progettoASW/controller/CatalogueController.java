package it.uniroma3.progettoASW.controller;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.uniroma3.progettoASW.persistence.exceptions.CatalogueNotFoundException;
import it.uniroma3.progettoASW.persistence.facade.CatalogueFacade;
import it.uniroma3.progettoASW.persistence.model.Catalogue;

@ManagedBean
public class CatalogueController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private Calendar lastUpdate;
	private Catalogue catalogue;
	private String genre;
	private List<Catalogue> catalogues;
	
	@EJB(name="catalogueFacade")
	private CatalogueFacade catalogueFacade;
	
	public String createCatalogue () {
		this.catalogue=this.catalogueFacade.addCatalogue(this.genre);
		return "catalogue";
	}
	
	public String findCatalogue() {
		try {
			this.catalogue=this.catalogueFacade.getCatalogue(this.genre.toLowerCase());
		} catch (CatalogueNotFoundException e) {
			e.printStackTrace();
		}
		return "catalogue";
	}
	
	public String getAllCatalogues()	{
		this.catalogues = this.catalogueFacade.getAllCatalogues();
		return "catalogues";
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

	public List<Catalogue> getCatalogues() {
		return catalogues;
	}

	public void setCatalogues(List<Catalogue> catalogues) {
		this.catalogues = catalogues;
	}
	


}