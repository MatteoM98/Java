package com.gammainnovation.agendastratta2;

public class AzioneAziende extends Azione{

	public AzioneAziende() {
		// TODO Auto-generated constructor stub
	}
	
	public AzioneAziende(Motore m) {
		super(m);
	}

	@Override
	public void agisci() {
		System.out.println("Sei sulla sezione aziende");
	}

}
