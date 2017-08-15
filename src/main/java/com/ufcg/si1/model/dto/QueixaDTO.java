package com.ufcg.si1.model.dto;

import com.ufcg.si1.model.Cidadao;
import com.ufcg.si1.model.Endereco;

public class QueixaDTO {
	private String descricao;
	
	private Cidadao cidadao;
	
	private Endereco endereco;
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cidadao getCidadao() {
		return cidadao;
	}

	public void setCidadao(Cidadao cidadao) {
		this.cidadao = cidadao;
	}

	public QueixaDTO() {
		super();
	}

	public QueixaDTO(String descricao) {
		super();
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Cidadao getSolicitante() {
		return this.cidadao;
	}
	
	public Endereco getEndereco() {
		return this.endereco;
	}
	
	
}
