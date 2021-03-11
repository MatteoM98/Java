package com.gammainnovation.agendastratta2;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {

		// Creazione Menu
		Menu menuPrincipale = new Menu("Menu Principale");
		Menu menuInserimento = new Menu("Menu Inserimento");
		Menu menuRicerca = new Menu("Menu Ricerca");
		
		//Creazione e voci
		Voce inserimento = new VoceDiNavigazione(1,"INSERIMENTO",menuInserimento);
		Voce ricerca = new VoceDiNavigazione(2,"RICERCA", menuRicerca);
		Voce fine = new VocediTerminazione(3,"FINE");
		
		HashMap<Integer,Voce> voci = new HashMap<Integer,Voce>();
		voci.put(1,inserimento);
		voci.put(2,ricerca);
		voci.put(3,fine);
	
		
		
		Voce studenti = new VoceDiAzione(1,"STUDENTI",new AzioneStudenti());
		Voce professori = new VoceDiAzione(2,"PROFESSORI",new AzioneProfessori());
		Voce aziende = new VoceDiAzione(3,"AZIENDE",new AzioneAziende());
		Voce mp = new VoceDiNavigazione(4,"MENU PRINCIPALE",menuPrincipale);
		
		HashMap<Integer,Voce> vociInserimentoRicerca = new HashMap<Integer,Voce>();
		vociInserimentoRicerca.put(1,studenti);
		vociInserimentoRicerca.put(2,professori);
		vociInserimentoRicerca.put(3,aziende);
		vociInserimentoRicerca.put(4,mp);
		
		// Configurazione dei menu
		menuPrincipale.setVoci(voci);
		menuInserimento.setVoci(vociInserimentoRicerca);
		menuRicerca.setVoci(vociInserimentoRicerca);
		
		// Avviamento motore
		Motore m = new Motore(menuPrincipale);
		m.start();
		
		
	}

}
