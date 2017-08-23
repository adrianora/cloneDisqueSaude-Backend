package com.ufcg.si1.service;

import com.ufcg.si1.model.Cidadao;
import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.QueixaAlimento;
import com.ufcg.si1.model.QueixaStatus;
import com.ufcg.si1.repository.QueixaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {

	@Autowired
	private QueixaRepository queixaRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private CidadaoService cidadaoService;
	
	private Queixa save(Queixa queixa) {
		return queixaRepository.save(queixa);
	}
	
	public Queixa add(Queixa queixa) {
		Cidadao cidadao = addCidadaoNoDB(queixa.getSolicitante());
		Endereco endereco = addEnderecoNoDB(queixa.getEndereco());
		return addQueixaNoDB(queixa, cidadao, endereco);
	}

	private Queixa addQueixaNoDB(Queixa queixa, Cidadao cidadao, Endereco endereco) {
		Queixa queixaInseridaNoBD = queixa;
		queixaInseridaNoBD.setSolicitante(cidadao);
		queixaInseridaNoBD.setEndereco(endereco);
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
	
	private Endereco addEnderecoNoDB(Endereco endereco) {
		Endereco enderecoInseridoNoBD;
		if (enderecoService.findByObject(endereco) == null)
			enderecoInseridoNoBD = enderecoService.save(endereco);
		else
			enderecoInseridoNoBD = enderecoService.findByObject(endereco);
		return enderecoInseridoNoBD;
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