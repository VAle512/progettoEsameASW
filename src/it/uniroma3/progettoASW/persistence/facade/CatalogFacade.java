package it.uniroma3.progettoASW.persistence.facade;

import java.util.GregorianCalendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.persistence.model.Catalog;
import it.uniroma3.progettoASW.persistence.util.HibernateUtil;

public class CatalogFacade {

	private Session session;
	
	public CatalogFacade(){
		this.session = HibernateUtil.getSession();
	}
	
	public Catalog addCatalog(Genre genre){
		Catalog c = new Catalog(new GregorianCalendar(), genre);
		Transaction tx = this.session.beginTransaction();
		this.session.persist(c);
		tx.commit();
		return c;
	}
	
	public Catalog getCatalog(Genre genre){
		Query q = this.session.createQuery("SELECT c FROM Catalog c WHERE genre = :genre");
		q.setParameter("genre",genre);
		Catalog c = (Catalog) q.uniqueResult();
		return c;
	}
	
}