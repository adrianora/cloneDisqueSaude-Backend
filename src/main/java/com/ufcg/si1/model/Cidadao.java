package com.ufcg.si1.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "tb_cidadaos")
public class Cidadao implements Serializable {

	private static final long serialVersionUID = 8916969152235733232L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidadao")
	private Long id;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(mappedBy = "solicitante")
	@JsonManagedReference
	Set<Queixa> queixas;

	public Cidadao() {
		
	}

	public Cidadao(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
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
