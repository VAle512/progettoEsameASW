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
		return doOperation (args);
	}


	//    /* metodo di supporto per la comunicazione remota */
	private String doOperation(String[] args) throws ServiceException, RemoteException {
		String reply=null;
		String title= args[0];
		int year= Integer.parseInt(args[1]);
		String director=args[2];
		int length=Integer.parseInt(args[3]);
		String genre=args[4];

		if (title==null || title.equals("") || director==null || director.equals("") || genre==null || genre.equals(""))
			throw new ServiceException("Parameters Error");
		try {
			Socket clientSocket= new Socket (address,port);
			DataOutputStream dOut = new DataOutputStream(clientSocket.getOutputStream());
			dOut.writeUTF(title + "," + year + "," + director + "," + length + "," + genre );
			dOut.flush();
			clientSocket.close();
		}
		catch (IOException e) {
			System.out.println("Errore di IO");
		}
		return reply;

	}


}
