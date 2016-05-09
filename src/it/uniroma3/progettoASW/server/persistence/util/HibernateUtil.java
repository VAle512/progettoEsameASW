package it.uniroma3.progettoASW.server.persistence.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
	private static Session session = null;
	private static final String CFG_PATH = "/server/persistence/resources/hibernate.cfg.xml";
	
	public static Session getSession(){
		if (session == null){
			StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure(CFG_PATH).build();
			SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
			session = sf.openSession();
		}
		return session;
	}
	
}