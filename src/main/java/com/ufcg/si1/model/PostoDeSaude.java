package com.ufcg.si1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_postosaude")
public class PostoDeSaude extends UnidadeDeSaude implements Serializable {

	private static final long serialVersionUID = 5000093145633078354L;
	
	@NotNull
	@Column(name = "atendentes")
	private int atendentes;
	
	@NotNull
	@Column(name = "taxa_diaria_atendimento")
	private int taxaDiariaAtendimento;
	
	public PostoDeSaude() {
		super();
		this.atendentes = 0;
		this.taxaDiariaAtendimento = 0;
	}
	
	public PostoDeSaude(String descricao, int atendentes, int taxaDiariaAtendimento) {
		super(descricao);
		this.atendentes = atendentes;
		this.taxaDiariaAtendimento = taxaDiariaAtendimento;
	}

	public int getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(int atendentes) {
		this.atendentes = atendentes;
	}

	public int getTaxaDiariaAtendimento() {
		return taxaDiariaAtendimento;
	}

	public void setTaxaDiariaAtendimento(int taxaDiariaAtendimento) {
		this.taxaDiariaAtendimento = taxaDiariaAtendimento;
	}
	
}
