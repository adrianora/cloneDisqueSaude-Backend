package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.pojo.EspecialidadeMedica;
import com.ufcg.si1.pojo.UnidadeDeSaude;

import exceptions.ObjetoInexistenteException;
import exceptions.UnidadeSaudeException;

public interface UnidadeSaudeService {

	UnidadeDeSaude save(UnidadeDeSaude unidade);

	UnidadeDeSaude delete(UnidadeDeSaude unidade);

	UnidadeDeSaude delete(Long unidadeId);

	UnidadeDeSaude findById(Long unidadeId) throws ObjetoInexistenteException;

	List<UnidadeDeSaude> findAll();
	
	UnidadeDeSaude addEspecialidadeMedica(Long unidadeSaudeId, EspecialidadeMedica especialidade) throws UnidadeSaudeException;
	
	List<UnidadeDeSaude> findByBairro(String bairro) throws UnidadeSaudeException;

	List<UnidadeDeSaude> findByEspecialidade(EspecialidadeMedica especialidade);

}