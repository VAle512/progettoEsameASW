package it.uniroma3.progettoASW.client.connector;

import it.uniroma3.progettoASW.service.RemoteException;
import it.uniroma3.progettoASW.service.Service;
import it.uniroma3.progettoASW.service.ServiceException;

import java.net.*;    
import java.io.*; 
import java.net.InetAddress;
import java.util.logging.Logger;

public class ClientProxy implements Service{
	
	private Logger logger = Logger.getLogger("it.uniroma3.progettoASW.client.connector");


	private InetAddress address;    // indirizzo del server
	private int port;               // porta per il servizio
	
	public ClientProxy(InetAddress address, int port)	{
		
		this.address = address;
		this.port = port;
	}

	public String insertMovie(String[] args) throws ServiceException, RemoteException {
    	return doOperation("insertMovie", args);
    }

// TODO Tivoliano devi fare il metodo doOperation a cui sto passando i pramanteri presi da terminale. 
	//  Sono 5 e siccome il main li prende come un array di stringhe te li passo come tali. 
	//  Credo sarà compito del proxy fare i dovuti cast e verificare che i dati siano corretti.
	//  Qualsiasi cosa scrivimi che poi vedo se risponderti.
	
	
//    /* metodo di supporto per la comunicazione remota */
    private String doOperation(String op, String[] args) throws ServiceException, RemoteException {
    	String result = null;
//    	Socket socket = null;
//        try {
//        	/* chiede una connessione al server */
//        	socket = new Socket(address, port);    // bloccante
//            /* solleva IOException, se si verifica un errore di I/O nella creazione del socket */
//
//        	/* imposta il timeout ad 1 secondo */
//            socket.setSoTimeout(1000);
//
//        	/* crea gli oggetti che rappresentano i due canali di comunicazione
//        	 * con il server */
//			DataInputStream in = new DataInputStream(socket.getInputStream());
//			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//
//        	/* codifica la richiesta di servizio e i relativi parametri */
//            /* la richiesta ha la forma "operazione$parametro" */
//			String request = op + "$" + arg;
//
//			/* invia la richiesta */
//            this.logger.info("Client Proxy: sending request: " + request);
//			out.writeUTF(request);    // non bloccante
//
//			/* riceve la risposta */
//			String reply = in.readUTF();    // bloccante
//       		this.logger.info("Client Proxy: received reply: " + reply);
//
//            /*
//             * elabora la risposta, che puo' avere le seguenti forme:
//             * "#risultato" oppure "@messaggio per eccezione"
//             */
//        	if (reply.startsWith("#")) {
//        		/* e' un risultato */
//        		result = reply.substring(1);
//        	} else if (reply.startsWith("@")) {
//        		/* si e' verificata una ServiceException */
//        		String message = reply.substring(1);
//        		throw new ServiceException(message);
//        	} else {
//        		/* risposta malformata, solleva una RemoteException */
//        		throw new RemoteException("Malformed reply: " + reply);
//        	}
//		} catch (UnknownHostException e) {
//			this.logger.info("Client Proxy: UnknownHostException: " + e.getMessage());
//			throw new RemoteException("UnknownHostException: " + e.getMessage());
//		} catch (EOFException e) {
//			this.logger.info("Client Proxy: EOFException: " + e.getMessage());
//			throw new RemoteException("EOFException: " + e.getMessage());
//		} catch (IOException e) {
//			this.logger.info("Client Proxy: IOException: " + e.getMessage());
//			throw new RemoteException("IOException: " + e.getMessage());
//		} finally {
//			if (socket!=null)
//				try { socket.close(); }
//				catch (IOException e) {
//					this.logger.info("Client Proxy: IOException: " + e.getMessage());
//					throw new RemoteException("IOException: " + e.getMessage());
//				}
//		}
        return result;
    }


}
