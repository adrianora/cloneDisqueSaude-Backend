package com.ufcg.si1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.pojo.Cidadao;
import com.ufcg.si1.repository.CidadaoRepository;

@Service("cidadaoService")
public class CidadaoServiceImpl implements CidadaoService {
	
	@Autowired
	private CidadaoRepository cidadaoRepository;

	@Override
	public Cidadao save(Cidadao objCidadao) {
		return cidadaoRepository.save(objCidadao);
	}

	@Override
	public Cidadao delete(Cidadao objCidadao) {
		cidadaoRepository.delete(objCidadao);
		return objCidadao;
	}

	@Override
	public Cidadao delete(Long cidadaoId) {
		cidadaoRepository.delete(cidadaoId);
		return cidadaoRepository.findOne(cidadaoId);
	}
	
	@Override
	public Cidadao findByObject(Cidadao objCidadao) {
		Cidadao cidadaoNoDB = null;
		int index = cidadaoRepository.findAll().indexOf(objCidadao);
		if (index != -1) {
			Cidadao entidadeNoBD = cidadaoRepository.findAll().get(index);
			cidadaoNoDB = cidadaoRepository.findOne(entidadeNoBD.getId());
		}
		return cidadaoNoDB;
	}

	@Override
	public Cidadao findById(Long cidadaoId) {
		return cidadaoRepository.findOne(cidadaoId);
	}

	@Override
	public List<Cidadao> findAll() {
		return cidadaoRepository.findAll();
	}

}
