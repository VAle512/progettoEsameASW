package it.uniroma3.progettoASW.server.persistence.facade;

import java.util.GregorianCalendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.server.persistence.model.Catalogue;
import it.uniroma3.progettoASW.server.persistence.util.HibernateUtil;

public class CatalogueFacade {

	private Session session;
	
	public CatalogueFacade(){
		this.session = HibernateUtil.getSession();
	}
	
	public Catalogue addCatalog(Genre genre){
		Catalogue c = new Catalogue(new GregorianCalendar(), genre);
		Transaction tx = this.session.beginTransaction();
		this.session.persist(c);
		tx.commit();
		return c;
	}
	
	public Catalogue getCatalog(Genre genre){
		Query q = this.session.createQuery("SELECT c FROM Catalog c WHERE genre = :genre");
		q.setParameter("genre",genre);
		Catalogue c = (Catalogue) q.uniqueResult();
		return c;
	}
	
}