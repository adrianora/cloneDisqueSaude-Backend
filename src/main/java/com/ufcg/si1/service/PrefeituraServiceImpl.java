package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.pojo.Prefeitura;
import com.ufcg.si1.pojo.PrefeituraStatus;
import com.ufcg.si1.pojo.QueixaSituacao;
import com.ufcg.si1.repository.PrefeituraRepository;

@Service("prefeituraService")
public class PrefeituraServiceImpl implements PrefeituraService {

	@Autowired
	private PrefeituraRepository prefeituraRepository;

	private Prefeitura prefeituraSingleton() {
		if (this.prefeituraRepository.count() == 0)
			return this.prefeituraRepository.save(new Prefeitura());
		else
			return prefeituraRepository.findOne(1L);
	}

	@Override
	public QueixaSituacao getSituacaoGeralQueixas(double relacaoQueixasAbertas) {
		return prefeituraSingleton().getSituacaoGeralQueixas(relacaoQueixasAbertas);
	}

	@Override
	public PrefeituraStatus getStatus() {
		return prefeituraSingleton().getSituacao();
	}

	@Override
	public void setPrefeituraStatus(PrefeituraStatus status) {
		if (prefeituraSingleton() != null) {
			prefeituraSingleton().setSituacao(status);
			this.prefeituraRepository.save(prefeituraSingleton());
		}
	}

}
