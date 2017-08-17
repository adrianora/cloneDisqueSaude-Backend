package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repository.AdministradorRepository;

@Service("adminService")
public class AdministradorServiceImpl implements AdministradorService {
	
	@Autowired
	private AdministradorRepository adminRepository;
	
	@Override
	public Administrador save(Administrador objAdmin) {
		return adminRepository.save(objAdmin);
	}

	@Override
	public Administrador findByObject(Administrador objAdmin) {
		Administrador adminNoDB = null;
		int index = adminRepository.findAll().indexOf(objAdmin);
		if (index != -1) {
			Administrador entidadeNoBD = adminRepository.findAll().get(index);
			adminNoDB = adminRepository.findOne(entidadeNoBD.getId());
		}
		return adminNoDB;
	}

}
