package com.ufcg.si1.service;

import com.ufcg.si1.model.EspecialidadeMedica;
import com.ufcg.si1.repository.EspecialidadeMedicaRepository;

import exceptions.ObjetoJaExistenteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeMedicaServiceImpl implements EspecialidadeMedicaService {

	@Autowired
	private EspecialidadeMedicaRepository especialidadeMedicaRepository;

	@Override
	public EspecialidadeMedica save(EspecialidadeMedica esp) throws ObjetoJaExistenteException  {
		if(existsEspecialidade(esp)) 
			throw new ObjetoJaExistenteException("Especialidade Media with description " + 
		esp.getDescricao() + " already exists");
		return especialidadeMedicaRepository.save(esp);
	}
	
	//Mudar isso daqui
	public boolean existsEspecialidade(EspecialidadeMedica esp) {
		List<EspecialidadeMedica> especialidades = this.findAll();
		for(EspecialidadeMedica e : especialidades) {
			if(e.getDescricao().equals(esp.getDescricao())) return true;
		}
		return false;
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
	public EspecialidadeMedica findById(Long espId) {
		return especialidadeMedicaRepository.findOne(espId);
	}

	@Override
	public List<EspecialidadeMedica> findAll() {
		return especialidadeMedicaRepository.findAll();
	}

}