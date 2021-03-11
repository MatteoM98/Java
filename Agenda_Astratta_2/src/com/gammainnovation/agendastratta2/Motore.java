package com.gammainnovation.agendastratta2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Motore {
	
	private Menu stato;
	public  final InputStreamReader isr = new InputStreamReader(System.in);
	public  final BufferedReader tast = new BufferedReader(isr);

	//Costruttori
	public Motore() {
		this.stato = null;
	}
	
	public Motore(Menu stato) {
		this.stato = stato;
	}

	//Metodi get e set
	public Menu getStato() {
		return stato;
	}

	public void setStato(Menu stato) {
		this.stato = stato;
	}
	
	//Metodi operativi
	public void start() {
		mostraMenu();
	}
	
	private void mostraMenu() {
		// stampa titolo menu
		// stampa indice e voci menu
		stato.stampaMenu();
		
		// prendi decisione da utente
		int scelta = 0;
		try {
			while(scelta<1 || scelta>stato.getVoci().size()) {
				System.out.print("Inserire numero scelta: ");
				String s = tast.readLine().trim();
				boolean t = s.matches("\\d+"); //espressione regolare per controllare che la stringa contenga un intero
				if(t)
					scelta = Integer.parseInt(s);
			}
		} catch (Exception e) {
			System.out.println("Errore lettura da tastiera: " + e.getMessage());
			System.exit(-1);
		}
		// valuta il tipo della voce 
		Voce v = stato.getVoci().get(scelta);
		// se è Azione -> agisci -> richiama mostra menu
		if(v instanceof Azionabile) {
			((Azionabile) v).attiva();
			System.out.println();
			mostraMenu();
		} else if (v instanceof Navigabile) { // se è Navigabile -> cambia stato -> richiama mostra menu
			stato = ((Navigabile) v).naviga();
			System.out.println();
			mostraMenu();
		} else {
			System.out.println("Errore: Tipo di voce non riconosciuto");
			System.exit(-1);
		}
	}
	
	
	

}
