package com.ufcg.si1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_postosaude")
public class PostoDeSaude extends UnidadeDeSaude implements Serializable {

	private static final long serialVersionUID = 5000093145633078354L;
	
	public PostoDeSaude() {
		super();
		super.setAtendentes(0);
		super.setTaxaDiariaAtendimento(0);
	}
	
	public PostoDeSaude(String bairro, int atendentes, int taxaDiariaAtendimento) {
		super(bairro);
		super.setAtendentes(atendentes);
		super.setTaxaDiariaAtendimento(taxaDiariaAtendimento);
	}
	
}
