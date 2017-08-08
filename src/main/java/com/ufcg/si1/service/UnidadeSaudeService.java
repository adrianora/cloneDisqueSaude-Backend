package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.UnidadeSaude;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

public interface UnidadeSaudeService {

	public UnidadeSaude save(UnidadeSaude unidade) throws ObjetoJaExistenteException;

	public UnidadeSaude delete(UnidadeSaude unidade);

	public UnidadeSaude delete(Long unidadeId);

	public UnidadeSaude findById(Long unidadeId) throws ObjetoInexistenteException;

	public List<UnidadeSaude> findAll();
	
	public UnidadeSaude findByBairro(String bairro) throws ObjetoInexistenteException;

}