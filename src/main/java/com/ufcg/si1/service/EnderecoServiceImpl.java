package com.ufcg.si1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.repository.EnderecoRepository;

@Service("enderecoService")
public class EnderecoServiceImpl implements EnderecoService {
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Endereco save(Endereco objEndereco) {
		return enderecoRepository.save(objEndereco);
	}

	@Override
	public Endereco delete(Endereco objEndereco) {
		enderecoRepository.delete(objEndereco);
		return objEndereco;
	}

	@Override
	public Endereco delete(Long enderecoId) {
		enderecoRepository.delete(enderecoId);
		return enderecoRepository.findOne(enderecoId);
	}
	
	@Override
	public Endereco findByObject(Endereco objEndereco) {
		Endereco enderecoNoDB = null;
		int index = enderecoRepository.findAll().indexOf(objEndereco);
		if (index != -1) {
			Endereco entidadeNoBD = enderecoRepository.findAll().get(index);
			enderecoNoDB = enderecoRepository.findOne(entidadeNoBD.getId());
		}
		return enderecoNoDB;
	}

	@Override
	public Endereco findById(Long enderecoId) {
		return enderecoRepository.findOne(enderecoId);
	}

	@Override
	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

}
