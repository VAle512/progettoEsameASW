package it.uniroma3.progettoASW.servant;

import it.uniroma3.progettoASW.client.context.ApplicationContext;
import it.uniroma3.progettoASW.server.Server;
import it.uniroma3.progettoASW.server.connector.ServerProxy;

public class Main {

	public static void main(String[] args){

		Servant servant;
		int port = 8080;

		servant = Server.getInstance().getServant();
		servant.run();
		ServerProxy proxy = new ServerProxy(port, servant);
		

	}

}
