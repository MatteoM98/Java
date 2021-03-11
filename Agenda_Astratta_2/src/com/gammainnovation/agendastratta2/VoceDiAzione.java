package com.gammainnovation.agendastratta2;

public class VoceDiAzione extends Voce implements Azionabile{

	private Azione azione;
	
	public VoceDiAzione() {
		super();
		this.azione = null;
	}
	
	public VoceDiAzione(int indice,String nome,Azione azione) {
		super(indice,nome);
		this.azione = azione;
	}

	public Azione getAzione() {
		return azione;
	}

	public void setAzione(Azione azione) {
		this.azione = azione;
	}

	@Override
	public void attiva() {
		azione.agisci();
	}
	

}
