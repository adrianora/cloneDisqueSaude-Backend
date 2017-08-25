package com.ufcg.si1.pojo;

import java.io.Serializable;

public class Endereco implements Serializable {

	private static final long serialVersionUID = -3189336984024792980L;

	private String rua;

	private String bairro;

	private String cidade;
	
	private String uf;
	
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

}
