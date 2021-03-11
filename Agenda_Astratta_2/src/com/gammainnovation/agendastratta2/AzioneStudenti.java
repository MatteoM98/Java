package com.gammainnovation.agendastratta2;

public class AzioneStudenti implements Azione {

	public AzioneStudenti() {
		super();
	}

	@Override
	public void agisci() {
		System.out.println("Sei sulla sezione studenti");
	}

}
