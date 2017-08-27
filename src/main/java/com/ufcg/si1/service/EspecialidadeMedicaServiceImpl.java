package com.ufcg.si1.service;

import com.ufcg.si1.pojo.EspecialidadeMedica;
import com.ufcg.si1.pojo.UnidadeDeSaude;
import com.ufcg.si1.repository.EspecialidadeMedicaRepository;

import exceptions.EspecialidadeMedicaException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("especialidadeService")
public class EspecialidadeMedicaServiceImpl implements EspecialidadeMedicaService {

	@Autowired
	private EspecialidadeMedicaRepository especialidadeMedicaRepository;

	@Override
	public EspecialidadeMedica save(EspecialidadeMedica esp) throws EspecialidadeMedicaException {
		if (contains(esp))
			throw new EspecialidadeMedicaException("ja existe no banco de dados.");
		return especialidadeMedicaRepository.save(esp);
	}

	@Override
	public EspecialidadeMedica delete(EspecialidadeMedica esp) throws EspecialidadeMedicaException {
		if (!contains(esp))
			throw new EspecialidadeMedicaException("nao existe no banco de dados.");
		especialidadeMedicaRepository.delete(esp);
		return esp;
	}

	@Override
	public EspecialidadeMedica delete(Long espId) throws EspecialidadeMedicaException {
		EspecialidadeMedica espResult = especialidadeMedicaRepository.findOne(espId);
		if (espResult == null)
			throw new EspecialidadeMedicaException("nao existe no banco de dados.");
		especialidadeMedicaRepository.delete(espResult);
		return espResult;
	}

	@Override
	public EspecialidadeMedica findById(Long espId) throws EspecialidadeMedicaException {
		EspecialidadeMedica espResult = especialidadeMedicaRepository.findOne(espId);
		if (espResult == null)
			throw new EspecialidadeMedicaException("nao existe no banco de dados.");
		return espResult;
	}

	/**
	 * Metodo utilizado pela service da Unidade de Saude. Nao utiliza exceptions e
	 * retorna existencia ou insercao do objeto no banco de dados.
	 */
	@Override
	public EspecialidadeMedica addEspecialidadeMedica(EspecialidadeMedica especialidade) {
		EspecialidadeMedica especialidadeNoBD = findByObject(especialidade);
		if (especialidadeNoBD == null)
			especialidadeNoBD = especialidadeMedicaRepository.save(especialidade);
		return especialidadeNoBD;
	}
	
	/**
	 * Realiza busca por especialidade medica no banco de dados.
	 */
	private EspecialidadeMedica findByObject(EspecialidadeMedica especialidade) {
		List<EspecialidadeMedica> especialidades = especialidadeMedicaRepository.findAll();
		EspecialidadeMedica especialidadeNoBD = null;
		for (int index = 0; index < especialidades.size(); index++) {
			if (especialidades.get(index).equals(especialidade))
				especialidadeNoBD = especialidades.get(index);
		}
		return especialidadeNoBD;
	}

	@Override
	public Set<UnidadeDeSaude> findEspecialidadeMedicaByUnidadeSaude(Long espId) throws EspecialidadeMedicaException {
		return findEspecialidadeMedica(espId).getUnidadesDeSaude();
	}

	/**
	 * Valida existencia da unidade de saude no banco de dados e acesso a objetos
	 * nulos, retornando exception.
	 */
	private EspecialidadeMedica findEspecialidadeMedica(long espId) throws EspecialidadeMedicaException {
		EspecialidadeMedica especialidade = especialidadeMedicaRepository.findOne(espId);
		if (especialidade == null)
			throw new EspecialidadeMedicaException("nao existe.");
		return especialidade;
	}

	/**
	 * Pesquisa na lista auxiliar a existencia de determinado objeto utilizando
	 * implementacao equals() da classe 'EspecialidadeMedica'.
	 */
	private boolean contains(EspecialidadeMedica especialidade) {
		boolean result = false;
		List<EspecialidadeMedica> espResult = especialidadeMedicaRepository.findAll();
		if (espResult.contains(especialidade))
			result = true;
		return result;
	}

	@Override
	public EspecialidadeMedica findByDescricao(String descricao) throws EspecialidadeMedicaException {
		List<EspecialidadeMedica> especialidades = especialidadeMedicaRepository.findAll();
		for (EspecialidadeMedica e : especialidades) {
			if(e.getDescricao().equals(descricao)) return e;
		}
		throw new EspecialidadeMedicaException("nao existe.");
	}

}