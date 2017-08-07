package com.ufcg.si1.factory;

import com.ufcg.si1.model.Endereco;

public class FactoryEndereco {
	
	public static Endereco buildEndereco(String rua, String uf, String cidade) {
		
		return new Endereco(rua, uf, cidade);
    }
}
