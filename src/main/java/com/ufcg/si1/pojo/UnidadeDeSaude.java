package com.ufcg.si1.pojo;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "tipo")
@JsonSubTypes({
	@JsonSubTypes.Type(value = PostoDeSaude.class, name = "posto"),
	@JsonSubTypes.Type(value = Hospital.class, name = "hospital") 
})
@Table(name = "tb_unidade_de_saude")
public abstract class UnidadeDeSaude implements Serializable {

	private static final long serialVersionUID = -4123181288224047925L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_unidade_de_saude")
	private Long id;
	
	@NotNull
	@Column(name = "atendentes")
	private int atendentes;
	
	@NotNull
	@Column(name = "taxa_diaria_atendimento")
	private int taxaDiariaAtendimento;
	
	@NotNull
	@Column(name = "endereco")
	private Endereco endereco;

	/**
	 * O relacionamento entre as especialidades medicas e a unidade se da como
	 * ManyToMany pelo fato da unidade de saude pode ter varias especialidades
	 * medicas, assim como um objeto especialidadeMedica poder estar presente em
	 * diversas unidades de saude.
	 * 
	 * O motivo de usar o FetchType "LAZY" eh o fato do join nas especialidades
	 * medicas ser realizado somente no momento que o atributo for utilizado.
	 * Diferente do "EAGER", que carrega todas as especialidades medicas no momento
	 * que o objeto foi criado/carregado.
	 */
	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "tb_unidade_de_saude_tem_especialidades",
			joinColumns = {@JoinColumn(name = "id_unidade_de_saude")},
			inverseJoinColumns = {@JoinColumn(name = "id_especialidade_medica")})
	private Set<EspecialidadeMedica> especialidadesMedicas;

	public UnidadeDeSaude() {
		this.especialidadesMedicas = new HashSet<EspecialidadeMedica>();
		this.atendentes = 0;
		this.taxaDiariaAtendimento = 0;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void addEspecialidadeMedica(EspecialidadeMedica especialidade) {
		this.especialidadesMedicas.add(especialidade);
	}

	public void setEspecialidadesMedicas(Set<EspecialidadeMedica> especialidadesMedicas) {
		this.especialidadesMedicas = especialidadesMedicas;
	}

	public Set<EspecialidadeMedica> getEspecialidadesMedicas() {
		return this.especialidadesMedicas;
	}

	public int getAtendentes() {
		return atendentes;
	}

	public void setAtendentes(int atendentes) {
		this.atendentes = atendentes;
	}

	public int getTaxaDiariaAtendimento() {
		return taxaDiariaAtendimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setTaxaDiariaAtendimento(int taxaDiariaAtendimento) {
		this.taxaDiariaAtendimento = taxaDiariaAtendimento;
	}
	
	public String getTipo() {
		return this.getClass().getSimpleName();
	}

}
