package com.ufcg.si1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_POSTODESAUDE")
public class PostoSaude extends UnidadeSaude implements Serializable {

	private static final long serialVersionUID = 5000093145633078354L;
	
	@NotNull
	@Column(name = "atendentes")
	private int atendentes;
	
	@NotNull
	@Column(name = "taxaDiariaAtendimentos")
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
