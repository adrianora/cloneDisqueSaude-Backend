package com.ufcg.si1.model;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "TB_PESSOAS")
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 8916969152235733232L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "nome")
	private String nome;

	public Pessoa() {

	}

	public Pessoa(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
