package com.ufcg.si1.model;

public class QueixaAlimento extends Queixa {
	
	public QueixaAlimento() {
		super();
	}
	
	public QueixaAlimento(String descricao, Cidadao solicitante, Endereco endereco) {
		super(descricao, solicitante, endereco);
	}
}
