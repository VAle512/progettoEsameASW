package it.uniroma3.progettoASW.client;

import java.util.logging.Logger;
import it.uniroma3.progettoASW.service.RemoteException;
import it.uniroma3.progettoASW.service.Service;
import it.uniroma3.progettoASW.service.ServiceException;

public class Client {

	private Logger logger = Logger.getLogger("it.uniroma3.progettoASW.client");
	private Service service;

	public Client() {
		this.logger.info("Creazione di un nuovo Client");
	}


	public void setService(Service service) {
		this.logger.info("Client: setService()");
		this.service = service;
	}

	public void run(String[] args) {
		this.logger.info("Client: Ora uso il servizio Service");
		this.logger.info("");
		this.logger.info("*** deve inserire un film nel catalogo");
		callInsertMovie(args);

		/* dovrebbe sollevare una ServiceException */
		//		logger.info("");
		//		logger.info("*** deve sollevare una ServiceException");
		//		callAlpha("Az");

		this.logger.info("");
		this.logger.info("Client: Ho finito di usare il servizio Service");
	}

	private void callInsertMovie(String[] args) {
		try {
			this.logger.info("Client: calling InsertMovie(" + args[0] + args[1] + args[2] + args[3] + args[4] + ")");
			String result = service.insertMovie(args);
			this.logger.info("Client: insertMovie(" + args[0] + args[1] + args[2] + args[3] + args[4] + ") ==> " + result);
		} catch (ServiceException e) {
			this.logger.info("Client: ServiceException while executing alpha(" + args[0] + args[1] + args[2] + args[3] + args[4] + ") ==> " + e.getMessage());
		} catch (RemoteException e) {
			this.logger.info("Client: RemoteException while executing alpha(" + args[0] + args[1] + args[2] + args[3] + args[4] + ") ==> " + e.getMessage());
		}
	}


}
