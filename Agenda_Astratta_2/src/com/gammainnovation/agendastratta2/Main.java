package com.gammainnovation.agendastratta2;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		
		//Creazione Motore
		Motore motore = new Motore();
		
		// Creazione Menu
		Menu menuPrincipale = new Menu("Menu Principale");
		Menu menuInserimento = new Menu("Menu Inserimento");
		Menu menuRicerca = new Menu("Menu Ricerca");
		
		
		//Creazione e voci
		Voce inserimento = new Voce(1,"INSERIMENTO",new AzioneDiNavigazione(menuInserimento,motore));
		Voce ricerca = new Voce(2,"RICERCA", new AzioneDiNavigazione(menuRicerca,motore));
		Voce fine = new Voce(3,"FINE", new AzioneDiTerminazione(motore));
		
		HashMap<Integer,Voce> voci = new HashMap<Integer,Voce>();
		voci.put(1,inserimento);
		voci.put(2,ricerca);
		voci.put(3,fine);
	
		
		
		Voce studenti = new Voce(1,"STUDENTI",new AzioneStudenti(motore));
		Voce professori = new Voce(2,"PROFESSORI",new AzioneProfessori(motore));
		Voce aziende = new Voce(3,"AZIENDE",new AzioneAziende(motore));
		Voce mp = new Voce(4,"MENU PRINCIPALE",new AzioneDiNavigazione(menuPrincipale,motore));
		
		HashMap<Integer,Voce> vociInserimentoRicerca = new HashMap<Integer,Voce>();
		vociInserimentoRicerca.put(1,studenti);
		vociInserimentoRicerca.put(2,professori);
		vociInserimentoRicerca.put(3,aziende);
		vociInserimentoRicerca.put(4,mp);
		
		// Configurazione dei menu
		menuPrincipale.setVoci(voci);
		menuInserimento.setVoci(vociInserimentoRicerca);
		menuRicerca.setVoci(vociInserimentoRicerca);
		
		//Configurazione e avviamento del motore
		motore.setStato(menuPrincipale);
		motore.start();
		
		
	}

}
