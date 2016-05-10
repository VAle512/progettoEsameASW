package it.uniroma3.progettoASW.server;

import java.net.InetAddress;
import java.util.logging.Logger;

import it.uniroma3.progettoASW.servant.Servant;
import it.uniroma3.progettoASW.server.connector.ServerProxy;

public class Server {
	
	private Logger logger = Logger.getLogger("it.uniroma3.progettoASW.server");
	
	private static int SERVER_PORT = 9876;
	
	private static Server instance = null;
	
	public static synchronized Server getInstance() {
		
		if (instance == null)
			instance = new Server();
		return instance;
	}
	
    public synchronized ServerProxy getService(String serverHost) {
		logger.info("Server: getService(" + serverHost + ")");
    	ServerProxy proxy = null;
    	try {
    		InetAddress address = InetAddress.getByName(serverHost);
    		int port = SERVER_PORT;
    		proxy = new ServerProxy(port,new Servant());
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return proxy;
	}
	
//    /* Factory method per il servant Servant.
//     * Ogni volta viene restituito un nuovo servant. */
//    
////    public Servant getServant() {
////		return getServant(SERVER_ADDRESS);
////    }
//
//    public Servant getServant(String serverHost) {
//		logger.info("Server: getServant(" + serverHost + ")");
//		Servant servant = new Servant();
//    	servant.setService( this.getService(serverHost) );
//        return servant;
//    }

}
