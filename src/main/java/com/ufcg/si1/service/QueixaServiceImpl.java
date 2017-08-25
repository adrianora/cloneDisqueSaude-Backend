package com.ufcg.si1.service;

import com.ufcg.si1.pojo.Cidadao;
import com.ufcg.si1.pojo.Queixa;
import com.ufcg.si1.pojo.QueixaStatus;
import com.ufcg.si1.repository.QueixaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {

	@Autowired
	private QueixaRepository queixaRepository;
	
	@Autowired
	private CidadaoService cidadaoService;
	
	private Queixa save(Queixa queixa) {
		return queixaRepository.save(queixa);
	}
	
	public Queixa add(Queixa queixa) {
		Cidadao cidadao = addCidadaoNoDB(queixa.getSolicitante());
		return addQueixaNoDB(queixa, cidadao);
	}

	private Queixa addQueixaNoDB(Queixa queixa, Cidadao cidadao) {
		Queixa queixaInseridaNoBD = queixa;
		queixaInseridaNoBD.setSolicitante(cidadao);
		return save(queixaInseridaNoBD);
	}
	
	private Cidadao addCidadaoNoDB(Cidadao cidadao) {
		Cidadao cidadaoInseridoNoBD;
		if (cidadaoService.findByObject(cidadao) == null)
			cidadaoInseridoNoBD = cidadaoService.save(cidadao);
		else
			cidadaoInseridoNoBD = cidadaoService.findByObject(cidadao);
		return cidadaoInseridoNoBD;
	}

	@Override
	public Queixa update(Queixa queixa) {
		return save(queixa);
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
	
	@Override
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