package com.ufcg.si1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufcg.si1.model.Administrador;
import com.ufcg.si1.repository.AdministradorRepository;

@Service("adminService")
public class AdministradorServiceImpl implements AdministradorService {

	@Autowired
	private AdministradorRepository adminRepository;

	/**
	 * Gera um singleton de super admin na primeira vez que o client tentar logar.
	 * Se o json enviado pelo client for igual ao singleton, o ponteiro eh alterado
	 * e retorna o objeto no banco de dados.
	 */
	@Override
	public Administrador login(Administrador objAdmin) {
		if (this.adminRepository.count() == 0)
			addSuperAdminSingleton();

		Administrador admin = findObject(objAdmin);

		if (admin != null && admin.equals(objAdmin))
			admin = this.adminRepository.findOne(1L);

		return admin;
	}

	/**
	 * Nao eh possivel adicionar novos administradores pelo front-end, no momento do
	 * primeiro login sera criado um único super administrador padrao
	 */
	private Administrador addSuperAdminSingleton() {
		Administrador superAdmin = new Administrador("admin", "admin@si1.com", "pass");
		return adminRepository.save(superAdmin);
	}

	/**
	 * Assumindo que apenas um super admin sera criado, a busca no repoistorio pela
	 * ID 1 eh imediata. Comparamos se o objeto de ID 1 eh diferente de null, ou
	 * seja, se foi encontrado e em seguida comparamos ao objeto em json enviado
	 * pelo usuario.
	 */
	private Administrador findObject(Administrador objAdmin) {
		Administrador adminNoBD = null;
		Administrador objNoBD = adminRepository.findOne(1L);

		if (objNoBD != null) {
			if (objNoBD.equals(objAdmin))
				adminNoBD = objAdmin;
		}

		return adminNoBD;
	}

}
