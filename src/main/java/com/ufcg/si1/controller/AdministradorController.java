package com.ufcg.si1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.service.AdministradorService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AdministradorController {
	
	@Autowired
	private AdministradorService administradorService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Administrador admin) {
		Administrador superAdmin = new Administrador("admin", "admin@si1.com", "admin");
		administradorService.save(superAdmin);
		
		Administrador objAdmin = administradorService.findByObject(admin);
		HttpStatus status = HttpStatus.NOT_FOUND;
		if (objAdmin != null) 
			status = HttpStatus.OK;
		return new ResponseEntity<>(objAdmin, status);
	}
	
}
