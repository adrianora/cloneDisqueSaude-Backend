package com.ufcg.si1.model;

public class PostoSaude extends UnidadeSaude {

	private int atendentes;
	private int taxaDiariaAtendimentos;
	
	public PostoSaude(String descricao, int atendentes, int taxaDiariaAtendimentos) {
		
		super(descricao);
		this.atendentes = atendentes;
		this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
	}

	public PostoSaude() {
		
		super();
		this.atendentes = 0;
		this.taxaDiariaAtendimentos = 0;
	}

	public int getAtendentes() {
		
		return atendentes;
	}

	public void setAtendentes(int atendentes) {
		
		this.atendentes = atendentes;
	}

	public int getTaxaDiariaAtendimentos() {
		
		return taxaDiariaAtendimentos;
	}

	public void setTaxaDiariaAtendimentos(int taxaDiariaAtendimentos) {
		
		this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
	}
	
}
