package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.QueixaStatus;
import com.ufcg.si1.repository.QueixaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {

	@Autowired
	QueixaRepository queixaRepository;

	@Override
	public Queixa save(Queixa queixa) {
		return queixaRepository.save(queixa);
	}
	

	@Override
	public Queixa delete(Queixa queixa) {
		Queixa queixaResult = queixaRepository.findOne(queixa.getId());
		queixaRepository.delete(queixaResult);
		return queixaResult;
	}

	@Override
	public Queixa delete(Long queixaId) {
		Queixa queixaResult = queixaRepository.findOne(queixaId);
		queixaRepository.delete(queixaResult);
		return queixaResult;
	}

	@Override
	public Queixa findById(Long queixaId) {
		return queixaRepository.findOne(queixaId);
	}

	@Override
	public List<Queixa> findAll() {
		return queixaRepository.findAll();
	}
	
	public double getRelacaoQueixasAbertas() {
		List<Queixa> queixas = this.findAll();
		double cont = 0;
		for(Queixa q : queixas) {
			if(q.getSituacao() == QueixaStatus.ABERTA)
				cont ++;
		}
		return cont / queixas.size();
	}

}