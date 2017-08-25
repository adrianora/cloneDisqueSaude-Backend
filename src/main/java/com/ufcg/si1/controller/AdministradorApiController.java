package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.pojo.Administrador;
import com.ufcg.si1.service.AdministradorService;

import exceptions.AdministradorException;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdministradorApiController {

	@Autowired
	private AdministradorService administradorService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Administrador admin) {
		Administrador adminNoBD;
		try {
			adminNoBD = administradorService.login(admin);
		} catch (AdministradorException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Administrador>(adminNoBD, HttpStatus.OK);
	}

}
