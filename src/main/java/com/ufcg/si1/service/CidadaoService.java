package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.pojo.Cidadao;

public interface CidadaoService {

	Cidadao save(Cidadao objCidadao);

	Cidadao delete(Cidadao objCidadao);

	Cidadao delete(Long cidadaoId);
	
	Cidadao findByObject(Cidadao objCidadao);

	Cidadao findById(Long cidadaoId);

	List<Cidadao> findAll();

}
