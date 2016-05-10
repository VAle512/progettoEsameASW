package it.uniroma3.progettoASW.server.connector;

import it.uniroma3.progettoASW.service.RemoteException;
import it.uniroma3.progettoASW.service.Service;
import it.uniroma3.progettoASW.service.ServiceException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class ServerProxy {
	private int port;
	private Service service;

	public ServerProxy (int port,Service service) {
		this.port = port;
		this.service=service;
	}
	
	public void addMovieToCatalogue() {
		String reply="";
		ServerSocket serverSocket=null;
		try {
			serverSocket = new ServerSocket(this.port);
			while (true) {
				Socket socket= serverSocket.accept();
				String fromClient="";
				DataInputStream dIn = new DataInputStream(socket.getInputStream());
				fromClient=dIn.readUTF();
				if (!fromClient.equals("")) {
					String[] infoMovie=fromClient.split(",");
					try {
						reply=service.insertMovie(infoMovie);
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				DataOutputStream dOut = new DataOutputStream(socket.getOutputStream());
				dOut.writeUTF(reply);
				if (reply.equals("Completed")) {
					socket.close();
					break;		
				}
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
	}

}

