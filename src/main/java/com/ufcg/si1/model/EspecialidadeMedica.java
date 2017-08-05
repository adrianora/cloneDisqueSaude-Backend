package com.ufcg.si1.model;

public class EspecialidadeMedica {

	private long id;
	private String descricao;

	public EspecialidadeMedica() {
		this.id = 0;
	}

	public EspecialidadeMedica(String descricao) {
		this.id = 0;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
}
