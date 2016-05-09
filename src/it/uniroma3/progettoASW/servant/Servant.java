package it.uniroma3.progettoASW.servant;

import java.util.logging.Logger;
import it.uniroma3.progettoASW.service.*;
import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.server.persistence.facade.MovieFacade;

public class Servant {
	
	
	private Logger logger = Logger.getLogger("it.uniroma3.progettoASW.client");
	private Service service;
	MovieFacade facade;
	
	public Servant(){
		this.logger.info("Creazione di un nuovo Servant");
	}
	
	public void setService(Service service) {
		this.logger.info("Servant: setService()");
		this.service = service;
	}
	
	public void run(){
		this.logger.info("Servant starting ... ");
		this.facade = new MovieFacade();
		
	}
	
	public void callAddMovie(String s1, String s2, String s3, String s4, String s5){
		
		this.logger.info("Inserimento nel catalogo \n");
		
		int i1 = Integer.parseInt(s2);
		int i2 = Integer.parseInt(s4);
		Genre genre = Genre.valueOf(s5);
		facade.addMovie(s1,i1,s3,i2,genre);
		
	}
	
	//riceve la risposta dell'inserimento dalla facade e la comunica al client
//	public String setResponse(){
//		
//		
//	}


}
