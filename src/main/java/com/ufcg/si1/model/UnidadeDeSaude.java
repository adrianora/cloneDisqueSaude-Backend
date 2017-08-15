package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
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
	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "unidadeDeSaude")
	@JsonManagedReference
	private Set<EspecialidadeMedica> especialidades;

	public UnidadeDeSaude() {
		this.especialidades = new HashSet<EspecialidadeMedica>();
	}

	public UnidadeDeSaude(String descricao) {
		this.descricao = descricao;
		this.especialidades = new HashSet<EspecialidadeMedica>();
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void addEspecialidadeMedica(EspecialidadeMedica especialidade) {
		this.especialidades.add(especialidade);
	}

	public Set<EspecialidadeMedica> getEspecialidadesMedicas() {
		return this.especialidades;
	}

	public abstract int getAtendentes();

	public abstract void setAtendentes(int atendentes);

	public abstract int getTaxaDiariaAtendimento();

	public abstract void setTaxaDiariaAtendimento(int taxaDiariaAtendimento);

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeDeSaude other = (UnidadeDeSaude) obj;
		if (this.descricao == null) {
			if (other.getDescricao() != null)
				return false;
		} else if (!this.descricao.equals(other.getDescricao()))
			return false;
		return true;
	}

}
