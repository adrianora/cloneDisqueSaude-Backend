package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	@Autowired
	UnidadeSaudeRepository unidadeSaudeRepository;

	@Override
	public UnidadeSaude save(UnidadeSaude unidade) throws ObjetoJaExistenteException {
		if(existsUnidadeSaude(unidade)) throw new ObjetoJaExistenteException(
				"Unidade de saude with descriptin: " + unidade.getDescricao() + " already exists");
		return unidadeSaudeRepository.save(unidade);
	}
	
	//Mudar isso
	public boolean existsUnidadeSaude(UnidadeSaude uni) {
		List<UnidadeSaude> unidades = this.findAll();
		if(unidades.contains(uni)) return true;
		return false;
	}
	
	//Isso tambem
	public UnidadeSaude findByBairro(String bairro) throws ObjetoInexistenteException {
		List<UnidadeSaude> unidades = this.findAll();
		for(UnidadeSaude u : unidades) {
			if(u.getDescricao().equals(bairro)) return u;
		}
		throw new ObjetoInexistenteException("Unidade de saude with "
				+ "description: " + bairro + " does not exist");
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
	public UnidadeSaude findById(Long unidadeId) throws ObjetoInexistenteException{
		UnidadeSaude unidade = unidadeSaudeRepository.findOne(unidadeId);
		if(unidade == null) 
			throw new ObjetoInexistenteException("Unidade de saude with " + unidadeId + " not found");
		return unidade;
	}

	@Override
	public List<UnidadeSaude> findAll() {
		return unidadeSaudeRepository.findAll();
	}
	
}