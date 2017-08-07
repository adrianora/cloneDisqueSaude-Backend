package com.ufcg.si1.service;

import com.ufcg.si1.model.EspecialidadeMedica;

import java.util.List;

public interface EspecialidadeMedicaService {
	
	public EspecialidadeMedica save(EspecialidadeMedica esp);
	
	public EspecialidadeMedica delete(EspecialidadeMedica esp);
	
	public EspecialidadeMedica delete(Long espId);
	
	public EspecialidadeMedica findOne(Long espId);
	
	public List<EspecialidadeMedica> findAll();

}