package com.gammainnovation.agendastratta2;

public class VocediTerminazione extends Voce implements Azionabile{

	public VocediTerminazione() {
		super();
	}
	
	public VocediTerminazione(int indice, String nome) {
		super(indice,nome);
	}

	@Override
	public void attiva() {
		System.exit(0);
	}

}
