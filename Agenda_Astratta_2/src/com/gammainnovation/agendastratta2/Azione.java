package com.gammainnovation.agendastratta2;

public abstract class Azione {

	private Motore motore;
	
	public Azione(Motore m) {
		this.motore = m;
	}
	
	public Azione() {
		this.motore = null;
	}
	
	public abstract void agisci();

	public Motore getMotore() {
		return motore;
	}

	public void setMotore(Motore m) {
		this.motore = m;
	}
	

}
