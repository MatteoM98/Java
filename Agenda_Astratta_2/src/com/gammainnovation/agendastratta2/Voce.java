package com.gammainnovation.agendastratta2;

public abstract class Voce {

	private int indice;
	private String nome;
	
	public Voce() {
		this.indice = 0;
		this.nome = null;
	}
	
	public Voce(int indice, String nome) {
		setIndice(indice);
		setNome(nome);
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
}
