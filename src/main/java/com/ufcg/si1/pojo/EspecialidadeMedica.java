package com.ufcg.si1.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_especialidade_medica")
public class EspecialidadeMedica implements Serializable {

	private static final long serialVersionUID = 4803095200989238369L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_especialidade_medica")
	private Long id;

	@NotNull
	@Column(name = "descricao")
	private String descricao;

	@JsonIgnore
	@ManyToMany(mappedBy="especialidadesMedicas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<UnidadeDeSaude> unidadesDeSaude;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<UnidadeDeSaude> getUnidadesDeSaude() {
		return unidadesDeSaude;
	}

	public void setUnidadesDeSaude(Set<UnidadeDeSaude> unidadesDeSaude) {
		this.unidadesDeSaude = unidadesDeSaude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EspecialidadeMedica other = (EspecialidadeMedica) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}

	
	
}
