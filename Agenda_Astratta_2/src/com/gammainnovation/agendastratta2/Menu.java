package com.gammainnovation.agendastratta2;

import java.util.HashMap;
import java.util.Map;

public class Menu {

	private String titolo;
	private HashMap<Integer,Voce> voci;
	
	//Costruttori
	public Menu() {
		this.titolo = "Nessun titolo";
		this.voci = new HashMap<Integer,Voce>();
	}
	
	public Menu(String titolo, HashMap<Integer,Voce> voci) {
		this.titolo = titolo;
		this.voci = voci;
	}
	
	public Menu(String titolo) {
		this.titolo = titolo;
		this.voci = null;
	}

	
	//Metodi
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public HashMap<Integer, Voce> getVoci() {
		return voci;
	}

	public void setVoci(HashMap<Integer, Voce> voci) {
		this.voci = voci;
	}
	
	public void stampaMenu() {
		System.out.println(titolo);
		for(Map.Entry<Integer, Voce> entry: voci.entrySet()) {
			System.out.println(entry.getKey() + ") " + entry.getValue().toString());
		}
	}
	


}
