package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeDeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;

	@Override
	public UnidadeDeSaude save(UnidadeDeSaude unidade) throws ObjetoJaExistenteException {
		if(existsUnidadeSaude(unidade)) throw new ObjetoJaExistenteException(
				"Unidade de saude with descriptin: " + unidade.getDescricao() + " already exists");
		return unidadeSaudeRepository.save(unidade);
	}
	
	//Mudar isso
	public boolean existsUnidadeSaude(UnidadeDeSaude uni) {
		List<UnidadeDeSaude> unidades = this.findAll();
		if(unidades.contains(uni)) return true;
		return false;
	}
	
	//Isso tambem
	public UnidadeDeSaude findByBairro(String bairro) throws ObjetoInexistenteException {
		List<UnidadeDeSaude> unidades = this.findAll();
		for(UnidadeDeSaude u : unidades) {
			if(u.getDescricao().equals(bairro)) return u;
		}
		throw new ObjetoInexistenteException("Unidade de saude with "
				+ "description: " + bairro + " does not exist");
	}

	@Override
	public UnidadeDeSaude delete(UnidadeDeSaude unidade) {
		UnidadeDeSaude unidadeResult = unidadeSaudeRepository.findOne(unidade.getId());
		unidadeSaudeRepository.delete(unidadeResult);
		return unidadeResult;
	}

	@Override
	public UnidadeDeSaude delete(Long unidadeId) {
		UnidadeDeSaude unidadeResult = unidadeSaudeRepository.findOne(unidadeId);
		unidadeSaudeRepository.delete(unidadeResult);
		return unidadeResult;
	}

	@Override
	public UnidadeDeSaude findById(Long unidadeId) throws ObjetoInexistenteException{
		UnidadeDeSaude unidade = unidadeSaudeRepository.findOne(unidadeId);
		if(unidade == null) 
			throw new ObjetoInexistenteException("Unidade de saude with " + unidadeId + " not found");
		return unidade;
	}

	@Override
	public List<UnidadeDeSaude> findAll() {
		return unidadeSaudeRepository.findAll();
	}
	
}