package com.ufcg.si1.service;

import exceptions.EspecialidadeMedicaException;

import java.util.Set;

import com.ufcg.si1.pojo.EspecialidadeMedica;
import com.ufcg.si1.pojo.UnidadeDeSaude;

public interface EspecialidadeMedicaService {
	
	EspecialidadeMedica save(EspecialidadeMedica esp) throws EspecialidadeMedicaException;
	
	EspecialidadeMedica delete(EspecialidadeMedica esp) throws EspecialidadeMedicaException;
	
	EspecialidadeMedica delete(Long espId) throws EspecialidadeMedicaException;
	
	EspecialidadeMedica findById(Long espId) throws EspecialidadeMedicaException;
	
	EspecialidadeMedica addEspecialidadeMedica(EspecialidadeMedica especialidade);
	
	Set<UnidadeDeSaude> findEspecialidadeMedicaByUnidadeSaude(Long espId) throws EspecialidadeMedicaException;

	EspecialidadeMedica findByDescricao(String descricao) throws EspecialidadeMedicaException;

}