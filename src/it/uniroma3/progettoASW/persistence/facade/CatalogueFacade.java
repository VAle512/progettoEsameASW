package it.uniroma3.progettoASW.persistence.facade;

import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.progettoASW.persistence.exceptions.CatalogueNotFoundException;
import it.uniroma3.progettoASW.persistence.model.Catalogue;

@Stateless(name="catalogueFacade")
public class CatalogueFacade {
	
	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;
	
	public Catalogue addCatalogue(String genre) {
		Catalogue c = new Catalogue(new GregorianCalendar(), genre);
		this.em.persist(c);
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public Catalogue getCatalogue(String genre) throws CatalogueNotFoundException {
		Query q = this.em.createQuery("SELECT c FROM Catalogue c");
		List<Catalogue> catalogues = q.getResultList();
		for (Catalogue c : catalogues)
			if (c.getGenre().equals(genre))
				return c;
		throw new CatalogueNotFoundException();
	}
	
	public Catalogue getCatalogue(Long id)  {
		Catalogue c = this.em.find(Catalogue.class, id);
		return c;
	}
	
	@SuppressWarnings("unchecked")
	public List<Catalogue> getAllCatalogues() {
		Query q = this.em.createQuery("SELECT c FROM Catalogue c");
		List<Catalogue> catalogues = q.getResultList();
		return catalogues;
		
	}
	
}