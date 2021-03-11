package com.gammainnovation.agendastratta2;

public class AzioneDiNavigazione extends Azione{

	private Menu m;
	
	public AzioneDiNavigazione() {
		super();
		this.m = null;
	}
	
	public AzioneDiNavigazione(Menu m) {
		super();
		this.m = m;
	}
	
	public AzioneDiNavigazione(Menu m,Motore mot) {
		super(mot);
		this.m = m;
	}
	
	@Override
	public void agisci() {
		Motore mot = this.getMotore();
		mot.setStato(m);
	}

}
