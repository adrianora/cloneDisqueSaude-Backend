package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.PostoSaude;
import com.ufcg.si1.model.UnidadeSaude;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;
import com.ufcg.si1.util.CustomErrorType;
import com.ufcg.si1.util.ObjWrapper;

import br.edu.ufcg.Hospital;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class HealthUnitApiController {

	UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeServiceImpl();

	/**
	 * Busca todas as unidades de saude.
	 */

	@RequestMapping(value = "/unidade/", method = RequestMethod.GET)
	public ResponseEntity<List> getAllUnidades() {

		List<UnidadeSaude> unidades = unidadeSaudeService.findAll();
		if (unidades.isEmpty()) {
			return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(unidades, HttpStatus.OK);
	}

	/**
	 * Salva uma nova Unidade de Saude.
	 */

	@RequestMapping(value = "/unidade/", method = RequestMethod.POST)
	public ResponseEntity<String> incluirUnidadeSaude(@RequestBody UnidadeSaude us, UriComponentsBuilder ucBuilder) {

		try {
			unidadeSaudeService.save(us);
		} catch (ObjetoJaExistenteException e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/unidade/{id}").buildAndExpand(us.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	/**
	 * Consulta uma unidade de saude com o id passado.
	 */

	@RequestMapping(value = "/unidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaude(@PathVariable("id") long id) throws ObjetoInexistenteException {

		UnidadeSaude us;
		try {
			us = unidadeSaudeService.findById(id);
		} catch (ObjetoInexistenteException ine) {
			return new ResponseEntity(new CustomErrorType("Unidade with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(us, HttpStatus.OK);
	}

	/**
	 * Busca uma unidade de saude pelo bairro.
	 */

	@RequestMapping(value = "/unidade/busca", method = RequestMethod.GET)
	public ResponseEntity<?> consultarUnidadeSaudePorBairro(
			@RequestParam(value = "bairro", required = true) String bairro) {

		UnidadeSaude us;

		try {
			us = unidadeSaudeService.findByBairro(bairro);
		} catch (ObjetoInexistenteException exp) {
			return new ResponseEntity(new CustomErrorType("Unidade with bairro " + bairro + " not found"),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<UnidadeSaude>(us, HttpStatus.OK);
	}

	/**
	 * Metodo para calcular a media medico de pacientes por dia, que eh a razao entre
	 * o numero de atendentes da unidade pela taxa diaria de atendimentos.
	 */

	@RequestMapping(value = "/geral/medicos/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> calcularMediaMedicoPacienteDia(@PathVariable("id") long id) {

		UnidadeSaude unidade;
		
		try {
			unidade = unidadeSaudeService.findById(id);
		}catch(ObjetoInexistenteException exp) {
			return new ResponseEntity<ObjWrapper<Double>>(HttpStatus.NOT_FOUND);
		}
		
		double c = unidade.getAtendentes() / unidade.getTaxaDiariaAtendimentos();

		return new ResponseEntity<ObjWrapper<Double>>(new ObjWrapper<Double>(new Double(c)), HttpStatus.OK);
	}

}
