package com.ufcg.si1.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_queixa_animal")
public class QueixaAnimal extends Queixa {
	
	private static final long serialVersionUID = -5407937938626842356L;
	
	@NotNull
	@Column(name = "tipo_animal")
	private String tipoAnimal;

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

}
