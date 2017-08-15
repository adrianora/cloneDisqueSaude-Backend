package com.ufcg.si1.service;

import com.ufcg.si1.model.EspecialidadeMedica;

import exceptions.ObjetoJaExistenteException;

import java.util.List;

public interface EspecialidadeMedicaService {
	
	EspecialidadeMedica save(EspecialidadeMedica esp) throws ObjetoJaExistenteException;
	
	EspecialidadeMedica delete(EspecialidadeMedica esp);
	
	EspecialidadeMedica delete(Long espId);
	
	EspecialidadeMedica findById(Long espId);
	
	List<EspecialidadeMedica> findAll();

}