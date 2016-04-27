package it.uniroma3.progettoASW.client.context;

import java.net.InetAddress;
import it.uniroma3.progettoASW.client.Client;
import it.uniroma3.progettoASW.client.connector.ClientProxy;
import it.uniroma3.progettoASW.service.Service;
import java.util.logging.Logger;

public class ApplicationContext {

	private Logger logger = Logger.getLogger("it.uniroma3.progettoASW.client.context");
	private static String SERVER_ADDRESS = "localhost";
	private static int SERVER_PORT = 6789;
	private static ApplicationContext instance = null;
	
	private ApplicationContext() {
		logger.info("Creazione dell'Application Context");
	}

    public static synchronized ApplicationContext getInstance() {
        if (instance==null) {
        	instance = new ApplicationContext();
        }
        return instance;
    }

    /* Factory method per il servizio Service.
     * Se possibile viene restituito uno stesso servizio. */
    public synchronized Service getService() {
		return getService(SERVER_ADDRESS);
	}

    public synchronized Service getService(String serverHost) {
		logger.info("ApplicationContext: getService(" + serverHost + ")");
    	Service proxy = null;
    	try {
    		InetAddress address = InetAddress.getByName(serverHost);
    		int port = SERVER_PORT;
    		proxy = new ClientProxy(address, port);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return proxy;
	}

    /* Factory method per il client Client.
     * Ogni volta viene restituito un nuovo client. */
    public Client getClient() {
		return getClient(SERVER_ADDRESS);
    }

    public Client getClient(String serverHost) {
		logger.info("ApplicationContext: getClient(" + serverHost + ")");
		Client client = new Client();
    	client.setService( this.getService(serverHost) );
        return client;
    }
}

