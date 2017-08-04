package com.ufcg.si1.model;

import java.util.ArrayList;
import java.util.List;

public class Hospital implements iUnidadeSaude {
	
	Hospital hospital;
	
	private int codigo;
    private String descricao;
    private List especialidades = new ArrayList();
    private long [] numeroQueixas = new long[1000];
    int contador = 0;

    public Hospital() {

    	super();
    }

    public void addQueixa(long id) {

    	numeroQueixas[contador] = id;
    	contador++;
    }

    public String getDescricao() {
        
    	return this.descricao;
    }

    public void setDescricao(String descricao) {
        
    	this.descricao = descricao;
    }

    public List<Especialidade> getEspecialidades() {
        
    	return this.especialidades;
    }

    public void adicionarEspecialidade(Especialidade esp) {
        
    	this.especialidades.add(esp);
    }

    public int getCodigo() {
        
    	return this.codigo;
    }

    public void setCodigo(int cod) {
        
    	this.codigo = cod;
    }
}
