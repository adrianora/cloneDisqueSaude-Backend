package com.ufcg.si1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import exceptions.ObjetoInvalidoException;

@Entity
@Table(name = "tb_queixa")
public class Queixa implements Serializable {

	private static final long serialVersionUID = 8981354144693127107L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_queixa")
	private Long id;
	
	@NotNull
	@Column(name = "descricao")
	private String descricao;
	
	@NotNull
	@Column(name = "comentario")
	private String comentario;
	
	@ManyToOne
	@JoinColumn(name = "id_cidadao")
	@JsonBackReference
	private Cidadao solicitante;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	@JsonBackReference
	private Endereco endereco;
	
	@Column(name = "situacao")
	private QueixaStatus situacao;

	public Queixa() {
		this.situacao = QueixaStatus.ABERTA;
	}

	public Queixa(String descricao, Cidadao solicitante, Endereco endereco) {
		this.descricao = descricao;
		this.situacao = QueixaStatus.ABERTA;
		this.solicitante = solicitante;
		this.endereco = endereco;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		else if (obj == null || getClass() != obj.getClass())
			return false;
		
		Queixa other = (Queixa) obj;
		return (this.id == other.id);
	}

}
