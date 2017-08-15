package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Endereco;

public interface EnderecoService {
	
	Endereco save(Endereco objEndereco);

	Endereco delete(Endereco objEndereco);

	Endereco delete(Long enderecoId);
	
	Endereco findByObject(Endereco objEndereco);

	Endereco findById(Long enderecoId);

	List<Endereco> findAll();

}
