package it.uniroma3.progettoASW.server.persistence.facade;

/**
 * L'eccezione TransactionException indica un problema nell'inserimento del film nel DataBase.
 *
 */

public class TrasactionException extends Exception {
	
		public TrasactionException(String message) {
			super(message);
		}
	}