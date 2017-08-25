package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.pojo.Administrador;
import com.ufcg.si1.repository.AdministradorRepository;

import exceptions.AdministradorException;

@Service("adminService")
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	private AdministradorRepository adminRepository;

	@Override
	public Administrador login(Administrador objAdmin) throws AdministradorException {
		singletonInitializer();
		return validateAdmin(objAdmin);
	}

	/**
	 * Assume que apenas um admin pode existir no sistema. Caso esteja igual a zero
	 * cria o primeiro e unico super usuario.
	 */
	private void singletonInitializer() {
		if (this.adminRepository.count() == 0)
			addSuperAdminSingleton();
	}

	/**
	 * Valida se o objeto enviado pelo usuario eh igual ao super admin do banco de
	 * dados. Os dados sao comparados apenas pelo email e senha.
	 */
	private Administrador validateAdmin(Administrador objAdmin) throws AdministradorException {
		Administrador admin = findObject(objAdmin);
		if (admin != null && admin.equals(objAdmin))
			admin = this.adminRepository.findOne(1L);
		else
			throw new AdministradorException();
		return admin;
	}

	private Administrador addSuperAdminSingleton() {
		Administrador superAdmin = new Administrador();
		superAdmin.setNome("admin");
		superAdmin.setEmail("admin@si1.com");
		superAdmin.setSenha("pass");
		return adminRepository.save(superAdmin);
	}

	/**
	 * Assumindo que apenas um super admin sera criado, a busca no repoistorio pela
	 * ID 1 eh imediata. Comparamos o objeto de ID 1 com o enviado pelo client.
	 */
	private Administrador findObject(Administrador objAdmin) {
		Administrador adminNoBD = null;
		Administrador objNoBD = adminRepository.findOne(1L);
		if (objNoBD != null && objNoBD.equals(objAdmin))
			adminNoBD = objAdmin;
		return adminNoBD;
	}

}
