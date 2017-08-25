package com.ufcg.si1.service;

import com.ufcg.si1.pojo.Administrador;

import exceptions.AdministradorException;

public interface AdministradorService {
	
	Administrador login(Administrador objAdmin) throws AdministradorException;
	
}
