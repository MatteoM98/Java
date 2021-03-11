package com.gammainnovation.agendastratta2;

public class AzioneProfessori extends Azione{

	public AzioneProfessori() {
		// TODO Auto-generated constructor stub
	}
	
	public AzioneProfessori(Motore m) {
		super(m);
	}

	@Override
	public void agisci() {
		System.out.println("Sei sulla sezione professori");
	}

}
