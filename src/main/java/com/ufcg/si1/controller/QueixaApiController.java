package com.ufcg.si1.controller;

import com.ufcg.si1.pojo.Queixa;
import com.ufcg.si1.service.QueixaService;
import com.ufcg.si1.util.CustomErrorType;

import exceptions.ObjetoInvalidoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class QueixaApiController {

	@Autowired
	private QueixaService queixaService;

	/**
	 * Lista todas as Queixas.
	 */
	@RequestMapping(value = "/queixa", method = RequestMethod.GET)
	public ResponseEntity<List<Queixa>> listAllUsers() {
		List<Queixa> queixas = queixaService.findAll();

		if (queixas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}

		return new ResponseEntity<List<Queixa>>(queixas, HttpStatus.OK);
	}

	/**
	 * Metodo utilizado para abrir uma queixa.
	 */
	@RequestMapping(value = "/queixa", method = RequestMethod.POST)
	public ResponseEntity<Queixa> abrirQueixa(@RequestBody Queixa queixa) {
		
		Queixa queixaPersistida = queixaService.add(queixa);
		
		return new ResponseEntity<Queixa>(queixaPersistida, HttpStatus.CREATED);
	}

	/**
	 * Consulta uma queixa pelo ID.
	 */
	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> consultarQueixa(@PathVariable("id") long id) {

		Queixa queixa = queixaService.findById(id);

		if (queixa == null) {

			return new ResponseEntity(new CustomErrorType("Queixa with id " + id + " not found"), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Queixa>(queixa, HttpStatus.OK);
	}

	/**
	 * Atualiza uma queixa, se encontrada, mudando sua descricao e comentario.
	 */
	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateQueixa(@PathVariable("id") long id, @RequestBody Queixa queixa) {

		Queixa currentQueixa = queixaService.findById(id);

		if (currentQueixa == null) {

			return new ResponseEntity(new CustomErrorType("Unable to upate. Queixa with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentQueixa.setDescricao(queixa.getDescricao());
		currentQueixa.setComentario(queixa.getComentario());

		currentQueixa = queixaService.update(currentQueixa);

		return new ResponseEntity<Queixa>(currentQueixa, HttpStatus.OK);
	}

	/**
	 * Deleta uma queixa pelo ID.
	 */
	@RequestMapping(value = "/queixa/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

		Queixa user = queixaService.findById(id);

		if (user == null) {

			return new ResponseEntity(new CustomErrorType("Unable to delete. Queixa with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		queixaService.delete(id);
		return new ResponseEntity<Queixa>(HttpStatus.NO_CONTENT);
	}

	/**
	 * Fecha uma queixa.
	 */
	@RequestMapping(value = "/queixa/fechamento", method = RequestMethod.PUT)
	public ResponseEntity<?> fecharQueixa(@RequestBody Queixa queixaAFechar) {
		try {
			queixaAFechar.fechar(queixaAFechar.getComentario());
		} catch (ObjetoInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		queixaService.update(queixaAFechar);
		return new ResponseEntity<Queixa>(queixaAFechar, HttpStatus.OK);
	}

}
