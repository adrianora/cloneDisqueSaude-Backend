package com.ufcg.si1.model;

public class PostoSaude extends UnidadeSaude{
	
    private int atendentes;
    private float taxaDiariaAtendimentos;

    public PostoSaude(){
    	
    	super();
    }

    public PostoSaude(String descricao, int atentendes, int taxa) {
        
    	super(descricao);
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
}
