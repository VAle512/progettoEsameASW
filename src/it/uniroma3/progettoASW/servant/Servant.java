package it.uniroma3.progettoASW.servant;

import java.util.logging.Logger;
import it.uniroma3.progettoASW.service.*;
import it.uniroma3.progettoASW.enums.Genre;
import it.uniroma3.progettoASW.server.persistence.facade.MovieFacade;

public class Servant implements Service {


	private Logger logger = Logger.getLogger("it.uniroma3.progettoASW.client");
	MovieFacade facade;

	public Servant(){
		this.logger.info("Creazione di un nuovo Servant");
	}


	public void run(){
		this.logger.info("Servant starting ... ");
		this.facade = new MovieFacade();

	}


	@Override
	public String insertMovie(String[] args) throws ServiceException, RemoteException {
		// TODO Auto-generated method stub
		this.logger.info("Inserimento nel catalogo \n");

		String title=args[0];
		int year=Integer.parseInt(args[1]);
		String director=args[2];
		int length=Integer.parseInt(args[3]);
		Genre genre=Genre.valueOf(args[4]);
		facade.addMovie(title,length,director,year,genre);
		return null;
	}

	//riceve la risposta dell'inserimento dalla facade e la comunica al client
	//	public String setResponse(){
	//		
	//		
	//	}


}
