package com.ufcg.si1.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.ArrayList;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = PostoSaude.class, name = "posto") })
public abstract class UnidadeSaude {
	
	private long id;
    private String descricao;
    private List<Long> especialidadesMedicas;
    private List<Long> queixas;

    public UnidadeSaude() {
    	this.id = 0;
    	this.especialidadesMedicas = new ArrayList<Long>();
        this.queixas = new ArrayList<Long>();
    }
    
    public UnidadeSaude(String descricao) {
        this.id = 0;
        this.descricao = descricao;
        this.especialidadesMedicas = new ArrayList<Long>();
        this.queixas = new ArrayList<Long>();
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public long getId() {
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

}
