package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Prefeitura;
import com.ufcg.si1.model.PrefeituraStatus;
import com.ufcg.si1.model.RelacaoQueixasStatus;
import com.ufcg.si1.service.PrefeituraService;
import com.ufcg.si1.service.QueixaService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PrefeituraController {
	
	@Autowired
	private QueixaService queixaService;
	
	@Autowired
	private PrefeituraService prefeitura;
	
	/**
	 * Retorna a situacao geral das queixas dependendo da situacao da prefeitura, Se
	 * normal: mais de 20% abertas eh ruim, mais de 10 eh regular Se extra: mais de
	 * 10% abertas eh ruim, mais de 5% eh regular O situacao retornada pode ser 0
	 * (ruim), 1 (regular) e 2 (bom).
	 */
	@RequestMapping(value = "/prefeitura", method = RequestMethod.GET)
	public ResponseEntity<RelacaoQueixasStatus> getSituacaoGeralQueixas() {
		double relacaoQueixasAbertas = queixaService.getRelacaoQueixasAbertas();
		RelacaoQueixasStatus situacaoGeralQueixas = prefeitura.getSituacaoGeralQueixas(relacaoQueixasAbertas);
		System.out.println(this.prefeitura.getStatus());		
		return new ResponseEntity<>(situacaoGeralQueixas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/prefeitura", method = RequestMethod.PUT)
	public ResponseEntity<PrefeituraStatus> modificarSituacaoPrefeitura(@RequestBody Prefeitura objPrefeitura) {
		PrefeituraStatus status = objPrefeitura.getSituacao();
		this.prefeitura.setPrefeituraStatus(status);
		return new ResponseEntity<>(this.prefeitura.getStatus(), HttpStatus.OK);
	}

}
