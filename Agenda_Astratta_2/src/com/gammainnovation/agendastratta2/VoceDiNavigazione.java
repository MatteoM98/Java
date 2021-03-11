package com.gammainnovation.agendastratta2;

public class VoceDiNavigazione extends Voce implements Navigabile{

	private Menu m;
	
	public VoceDiNavigazione() {
		super();
		this.m = null;
	}
	
	public VoceDiNavigazione(int indice, String nome,Menu m ) {
		super(indice,nome);
		this.m = m;
	}
	
	public Menu getM() {
		return m;
	}
	
	public void setM(Menu m) {
		this.m = m;
	}

	@Override
	public Menu naviga() {
		return m;
	}

}
