package com.ufcg.si1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_ESPECIALIDADEMEDICA")
public class EspecialidadeMedica implements Serializable {

	private static final long serialVersionUID = 4803095200989238369L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(name = "descricao")
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
