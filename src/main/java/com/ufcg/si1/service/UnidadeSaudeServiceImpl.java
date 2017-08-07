package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	@Autowired
	UnidadeSaudeRepository unidadeSaudeRepository;

	@Override
	public UnidadeSaude save(UnidadeSaude unidade) {
		return unidadeSaudeRepository.save(unidade);
	}

	@Override
	public UnidadeSaude delete(UnidadeSaude unidade) {
		UnidadeSaude unidadeResult = unidadeSaudeRepository.findOne(unidade.getId());
		unidadeSaudeRepository.delete(unidadeResult);
		return unidadeResult;
	}

	@Override
	public UnidadeSaude delete(Long unidadeId) {
		UnidadeSaude unidadeResult = unidadeSaudeRepository.findOne(unidadeId);
		unidadeSaudeRepository.delete(unidadeResult);
		return unidadeResult;
	}

	@Override
	public UnidadeSaude findOne(Long unidadeId) {
		return unidadeSaudeRepository.findOne(unidadeId);
	}

	@Override
	public List<UnidadeSaude> findAll() {
		return unidadeSaudeRepository.findAll();
	}
	
}