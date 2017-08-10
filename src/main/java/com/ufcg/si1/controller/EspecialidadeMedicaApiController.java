package com.ufcg.si1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ufcg.si1.model.EspecialidadeMedica;
import com.ufcg.si1.model.UnidadeDeSaude;
import com.ufcg.si1.service.EspecialidadeMedicaService;
import com.ufcg.si1.service.EspecialidadeMedicaServiceImpl;
import com.ufcg.si1.service.UnidadeSaudeService;
import com.ufcg.si1.service.UnidadeSaudeServiceImpl;
import com.ufcg.si1.util.CustomErrorType;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EspecialidadeMedicaApiController {

	@Autowired
	private EspecialidadeMedicaService especialidadeService;
	
	@Autowired
	private UnidadeSaudeService unidadeSaudeService;

	/**
	 * Busca as especialidades de uma determinada Unidade de Saude.
	 */
	@RequestMapping(value = "/especialidade/unidades/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultaEspecialidadeporUnidadeSaude(@PathVariable("id") long id) {

		UnidadeDeSaude us;
		try {
			us = unidadeSaudeService.findById(id);
		} catch (ObjetoInexistenteException e) {
			return new ResponseEntity<List>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

	/**
	 * Inclui uma nova especialidade, caso a mesma não exista na API.
	 */
	@RequestMapping(value = "/especialidade/", method = RequestMethod.POST)
	public ResponseEntity<String> incluirEspecialidade(@RequestBody EspecialidadeMedica esp,
			UriComponentsBuilder ucBuilder) {

		try {
			especialidadeService.save(esp);
		} catch (ObjetoJaExistenteException e) {
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		// Descobrir oq eh isso
		//HttpHeaders headers = new HttpHeaders();
		//headers.setLocation(ucBuilder.path("/api/especialidade/{id}").buildAndExpand(esp.getCodigo()).toUri());

		return new ResponseEntity<String>("Especialidade incluida", HttpStatus.CREATED);
	}

	/**
	 * Consulta uma especialidade com um determinado id.
	 */
	@RequestMapping(value = "/especialidade/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarEspecialidade(@PathVariable("id") long id) {

		EspecialidadeMedica esp = especialidadeService.findById(id);

		if (esp == null) {
			return new ResponseEntity<CustomErrorType>(new CustomErrorType("Especialidade with id " + id + " not found"),
					HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<EspecialidadeMedica>(esp, HttpStatus.OK);
	}

}
