package com.ufcg.si1.service;

import com.ufcg.si1.model.EspecialidadeMedica;

import exceptions.ObjetoJaExistenteException;

import java.util.List;

public interface EspecialidadeMedicaService {
	
	public EspecialidadeMedica save(EspecialidadeMedica esp) throws ObjetoJaExistenteException;
	
	public EspecialidadeMedica delete(EspecialidadeMedica esp);
	
	public EspecialidadeMedica delete(Long espId);
	
	public EspecialidadeMedica findById(Long espId);
	
	public List<EspecialidadeMedica> findAll();

}