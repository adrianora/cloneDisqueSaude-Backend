package com.ufcg.si1.model;

import java.util.ArrayList;
import java.util.List;

public class PostoSaude implements iUnidadeSaude {
	
	private int codigo;
    private String descricao;
    private List especialidades = new ArrayList();
    private long [] numeroQueixas = new long[1000];
    int contador = 0;
	private int atendentes;
    private float taxaDiariaAtendimentos;

    public PostoSaude(){
    	
    	super();
    }

    public PostoSaude(String descricao, int atentendes, int taxa) {
        
    	this.descricao = descricao;
        this.atendentes = atentendes;
        this.taxaDiariaAtendimentos = taxa;
    }

    public int getAtendentes() {
        
    	return this.atendentes;
    }

    public float taxaDiaria() {
    	
        return this.taxaDiariaAtendimentos;
    }

    public void setAtendentes(int atendentes) {
        
    	this.atendentes = atendentes;
    }

    public float getTaxaDiariaAtendimentos() {
        
    	return taxaDiariaAtendimentos;
    }

    public void setTaxaDiariaAtendimentos(float taxaDiariaAtendimentos) {
        
    	this.taxaDiariaAtendimentos = taxaDiariaAtendimentos;
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
