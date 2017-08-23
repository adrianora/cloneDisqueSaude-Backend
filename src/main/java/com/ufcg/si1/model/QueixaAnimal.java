package com.ufcg.si1.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class QueixaAnimal extends Queixa {
	
	@NotNull
	@Column(name = "tipoAnimal")
	private String tipoAnimal;
	
	public QueixaAnimal() {
		super();
	}
	
	public QueixaAnimal(String descricao, Cidadao solicitante, Endereco endereco, String tipoAnimal) {
		super(descricao, solicitante, endereco);
		this.tipoAnimal = tipoAnimal;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}