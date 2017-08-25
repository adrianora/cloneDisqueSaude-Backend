package com.ufcg.si1.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_prefeitura")
public class Prefeitura implements Serializable {
	
	private static final long serialVersionUID = -2425300054583652213L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prefeitura")
	private Long id;

	@NotNull
	@Column(name = "situacao")
	private PrefeituraStatus situacao;
	
	public Prefeitura() {
		this.situacao = PrefeituraStatus.NORMAL;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PrefeituraStatus getSituacao() {
		return this.situacao;
	}
	
	public void setSituacao(PrefeituraStatus status) {
		this.situacao = status;
	}
	
	public QueixaSituacao getSituacaoGeralQueixas(double relacaoQueixasAbertas) {
		return this.situacao.calcula(relacaoQueixasAbertas);
	}
	
}
