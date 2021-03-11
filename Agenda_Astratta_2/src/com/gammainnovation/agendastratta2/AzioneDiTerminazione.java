package com.gammainnovation.agendastratta2;

public class AzioneDiTerminazione extends Azione {

	public AzioneDiTerminazione() {
		super();
	}
	
	public AzioneDiTerminazione(Motore m) {
		super(m);
	}
	
	@Override
	public void agisci() {
		System.out.println("Bye bye...");
		System.exit(0);
	}

}
