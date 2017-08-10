package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.UnidadeDeSaude;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

public interface UnidadeSaudeService {

	public UnidadeDeSaude save(UnidadeDeSaude unidade) throws ObjetoJaExistenteException;

	public UnidadeDeSaude delete(UnidadeDeSaude unidade);

	public UnidadeDeSaude delete(Long unidadeId);

	public UnidadeDeSaude findById(Long unidadeId) throws ObjetoInexistenteException;

	public List<UnidadeDeSaude> findAll();
	
	public UnidadeDeSaude findByBairro(String bairro) throws ObjetoInexistenteException;

}