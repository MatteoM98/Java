package com.gammainnovation.agendastratta2;

public class AzioneStudenti extends Azione {

	public AzioneStudenti() {
		super();
	}
	
	public AzioneStudenti(Motore m) {
		super(m);
	}

	@Override
	public void agisci() {
		System.out.println("Sei sulla sezione studenti");
	}

}
