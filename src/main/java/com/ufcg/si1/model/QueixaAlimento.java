package com.ufcg.si1.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_queixa_alimento")
public class QueixaAlimento extends Queixa {
	
	public QueixaAlimento() {
		super();
	}
	
	public QueixaAlimento(String descricao, Cidadao solicitante, Endereco endereco) {
		super(descricao, solicitante, endereco);
	}
}
