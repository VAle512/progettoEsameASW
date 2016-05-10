package it.uniroma3.progettoASW.persistence.facade;

import java.util.GregorianCalendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.persistence.model.Catalogue;

@Stateless(name="catalogueFacade")
public class CatalogueFacade {
	
	@PersistenceContext(unitName = "dbProgettoASW-unit")
	private EntityManager em;
	
	public Catalogue addCatalog(Genre genre) {
		Catalogue c = new Catalogue(new GregorianCalendar(), genre);
		this.em.persist(c);
		return c;
	}
	
	public Catalogue getCatalog(Genre genre) {
		Query q = this.em.createQuery("SELECT c FROM Catalog c WHERE genre = :genre");
		q.setParameter("genre",genre);
		Catalogue c =  (Catalogue) q.getSingleResult();
		return c;
	}
	
}