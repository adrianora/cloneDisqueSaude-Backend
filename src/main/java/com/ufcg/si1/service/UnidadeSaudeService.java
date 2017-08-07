package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.UnidadeSaude;

public interface UnidadeSaudeService {

	public UnidadeSaude save(UnidadeSaude unidade);

	public UnidadeSaude delete(UnidadeSaude unidade);

	public UnidadeSaude delete(Long unidadeId);

	public UnidadeSaude findOne(Long unidadeId);

	public List<UnidadeSaude> findAll();

}