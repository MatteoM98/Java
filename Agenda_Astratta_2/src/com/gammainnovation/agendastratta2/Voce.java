package com.gammainnovation.agendastratta2;

public class Voce {

	private int indice;
	private String nome;
	private Azione azione;
	
	public Voce() {
		this.indice = 0;
		this.nome = null;
	}
	
	public Voce(int indice, String nome) {
		setIndice(indice);
		setNome(nome);
	}
	
	public Voce(int indice, String nome, Azione azione) {
		setIndice(indice);
		setNome(nome);
		setAzione(azione);
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
	
	public Azione getAzione() {
		return azione;
	}

	public void setAzione(Azione azione) {
		this.azione = azione;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
