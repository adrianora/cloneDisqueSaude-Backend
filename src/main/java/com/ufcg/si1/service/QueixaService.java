package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.pojo.Queixa;

public interface QueixaService {
	
	Queixa add(Queixa queixa);

	Queixa update(Queixa queixa);
	
	Queixa delete(Queixa queixa);
	
	Queixa delete(Long queixaId);
	
	Queixa findById(Long queixaId);
	
	List<Queixa> findAll();
	
	double getRelacaoQueixasAbertas();

}