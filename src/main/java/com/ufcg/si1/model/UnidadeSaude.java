package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_UNIDADEDESAUDE")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = PostoSaude.class, name = "posto") })
public abstract class UnidadeSaude implements Serializable {
	
	private static final long serialVersionUID = -4123181288224047925L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(name = "descricao")
    private String descricao;
    
	@NotNull
	@Column(name = "especialidadesMedicas")
	private List<Long> especialidadesMedicas;
    
	@NotNull
	@Column(name = "queixas")
	private List<Long> queixas;

    public UnidadeSaude() {
    	this.especialidadesMedicas = new ArrayList<Long>();
        this.queixas = new ArrayList<Long>();
    }
    
    public UnidadeSaude(String descricao) {
        this.descricao = descricao;
        this.especialidadesMedicas = new ArrayList<Long>();
        this.queixas = new ArrayList<Long>();
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

    public void addEspecialidadeMedica(long idEspecialidade) {
        this.especialidadesMedicas.add(idEspecialidade);
    }
    
    public List<Long> getEspecialidadesMedicas() {
        return this.especialidadesMedicas;
    }

    public void addQueixa(long id) {
    	this.queixas.add(id);
    }
    
    public List<Long> getQueixas() {
    	return this.queixas;
    }
    
    public abstract int getAtendentes();
    
    public abstract int getTaxaDiariaAtendimentos();
    
    public abstract void setAtendentes(int atendentes);
    
    public abstract void setTaxaDiariaAtendimentos(int taxaDiariaAtendimentos);
    
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeSaude other = (UnidadeSaude) obj;
		if (this.descricao == null) {
			if (other.getDescricao() != null)
				return false;
		} else if (!this.descricao.equals(other.getDescricao()))
			return false;
		return true;
	}

}
