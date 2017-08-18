package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.UnidadeDeSaude;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

public interface UnidadeSaudeService {

	UnidadeDeSaude save(UnidadeDeSaude unidade) throws ObjetoJaExistenteException;

	UnidadeDeSaude delete(UnidadeDeSaude unidade);

	UnidadeDeSaude delete(Long unidadeId);

	UnidadeDeSaude findById(Long unidadeId) throws ObjetoInexistenteException;

	List<UnidadeDeSaude> findAll();
	
	List<UnidadeDeSaude> getByBairro(String bairro) throws ObjetoInexistenteException;

}