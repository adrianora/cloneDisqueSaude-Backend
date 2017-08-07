package com.ufcg.si1.service;

import com.ufcg.si1.model.EspecialidadeMedica;
import com.ufcg.si1.repository.EspecialidadeMedicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeMedicaServiceImpl implements EspecialidadeMedicaService {

	@Autowired
	EspecialidadeMedicaRepository especialidadeMedicaRepository;

	@Override
	public EspecialidadeMedica save(EspecialidadeMedica esp) {
		return especialidadeMedicaRepository.save(esp);
	}

	@Override
	public EspecialidadeMedica delete(EspecialidadeMedica esp) {
		EspecialidadeMedica espResult = especialidadeMedicaRepository.findOne(esp.getId());
		especialidadeMedicaRepository.delete(espResult);
		return espResult;
	}

	@Override
	public EspecialidadeMedica delete(Long espId) {
		EspecialidadeMedica espResult = especialidadeMedicaRepository.findOne(espId);
		especialidadeMedicaRepository.delete(espResult);
		return espResult;
	}

	@Override
	public EspecialidadeMedica findOne(Long espId) {
		return especialidadeMedicaRepository.findOne(espId);
	}

	@Override
	public List<EspecialidadeMedica> findAll() {
		return especialidadeMedicaRepository.findAll();
	}

}