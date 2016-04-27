package it.uniroma3.progettoASW.server.connector;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;

public class ServerProxy {
	private int port;

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
					String title=infoMovie[0];
					int year=Integer.parseInt(infoMovie[1]);
					String director=infoMovie[2];
					int length=Integer.parseInt(infoMovie[3]);
					String genre=infoMovie[4];
					//chiamata al servizio del Server che si occupa della persistenza
					// passando qyeste 5 stringhe
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

