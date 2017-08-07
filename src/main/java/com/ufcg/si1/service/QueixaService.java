package com.ufcg.si1.service;

import java.util.List;

import com.ufcg.si1.model.Queixa;

public interface QueixaService {

	public Queixa save(Queixa queixa);
	
	public Queixa delete(Queixa queixa);
	
	public Queixa delete(Long queixaId);
	
	public Queixa findOne(Long queixaId);
	
	public List<Queixa> findAll();

}