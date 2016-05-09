package it.uniroma3.progettoASW.server.connector;

import it.uniroma3.progettoASW.service.RemoteException;
import it.uniroma3.progettoASW.service.Service;
import it.uniroma3.progettoASW.service.ServiceException;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class ServerProxy {
	private int port;
	private Service service;

	public ServerProxy (int port) {
		this.port = port;
	}
	// service exception per i parametri da implementare
	public String addMovieToCatalogue() {
		String reply=null;
		ServerSocket serverSocket=null;
		try {
			serverSocket = new ServerSocket(this.port);
			while (true) {
				Socket socket= serverSocket.accept();
				String fromClient="";
				DataInputStream dIn = new DataInputStream(socket.getInputStream());
				fromClient=dIn.readUTF();
				//                try {
				//                	

				if (!fromClient.equals("")) {
					String[] infoMovie=fromClient.split(",");
					try {
						service.insertMovie(infoMovie);
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}


				//                }
				//                catch (ServiceException e) {
				//                	
				//                }

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (serverSocket!= null)
				try {
					serverSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}


		return reply;

	}

}

