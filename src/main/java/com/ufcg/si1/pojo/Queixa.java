package com.ufcg.si1.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import exceptions.ObjetoInvalidoException;

@Entity
@Table(name = "tb_queixa")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
	@JsonSubTypes.Type(value = QueixaAnimal.class, name = "animal"),
	@JsonSubTypes.Type(value = QueixaAlimento.class, name = "alimento"),
	@JsonSubTypes.Type(value = QueixaGeral.class, name = "geral")
})
public abstract class Queixa implements Serializable {

	private static final long serialVersionUID = 8981354144693127107L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_queixa")
	private Long id;
	
	@NotNull
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "comentario")
	private String comentario;
	
	@NotNull
	@Column(name = "id_cidadao")
	private Cidadao solicitante;
	
	@NotNull
	@Column(name = "id_endereco")
	private Endereco endereco;
	
	@NotNull
	@Column(name = "situacao")
	private QueixaStatus situacao;

	public Queixa() {
		this.situacao = QueixaStatus.ABERTA;
	}

	public void abrir() throws ObjetoInvalidoException {
		if (this.situacao == QueixaStatus.EM_ANDAMENTO || this.situacao == QueixaStatus.FECHADA)
			this.situacao = QueixaStatus.ABERTA;
		else
			throw new ObjetoInvalidoException("Queixa já está aberta");
	}

	public void fechar(String comentario) throws ObjetoInvalidoException {
		if (this.situacao == QueixaStatus.EM_ANDAMENTO || this.situacao == QueixaStatus.ABERTA) {
			this.situacao = QueixaStatus.FECHADA;
			this.comentario = comentario;
		} else {
			throw new ObjetoInvalidoException("Queixa já está fechada");
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Cidadao getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(Cidadao solicitante) {
		this.solicitante = solicitante;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public QueixaStatus getSituacao() {
		return situacao;
	}

	public void setSituacao(QueixaStatus situacao) {
		this.situacao = situacao;
	}

}
