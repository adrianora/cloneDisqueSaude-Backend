package com.ufcg.si1.service;

import com.ufcg.si1.model.Administrador;

public interface AdministradorService {
	
	Administrador save(Administrador objAdmin);

	Administrador findByObject(Administrador objAdmin);
	
}
