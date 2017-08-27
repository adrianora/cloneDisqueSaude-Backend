package com.ufcg.si1.service;

import com.ufcg.si1.pojo.EspecialidadeMedica;
import com.ufcg.si1.pojo.UnidadeDeSaude;
import com.ufcg.si1.repository.UnidadeSaudeRepository;

import exceptions.ObjetoInexistenteException;
import exceptions.UnidadeSaudeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {

	@Autowired
	private UnidadeSaudeRepository unidadeSaudeRepository;
	
	@Autowired
	private EspecialidadeMedicaService especialidadeMedicaService;

	@Override
	public UnidadeDeSaude save(UnidadeDeSaude unidade){
		UnidadeDeSaude unidadeNoBD = unidade;
		Set<EspecialidadeMedica> especialidadesNoBD = addEspecialidadesMedicasNoRepository(unidade.getEspecialidadesMedicas());
		unidadeNoBD.setEspecialidadesMedicas(especialidadesNoBD);
		return unidadeSaudeRepository.save(unidadeNoBD);
	}
	
	private Set<EspecialidadeMedica> addEspecialidadesMedicasNoRepository(Set<EspecialidadeMedica> especialidades) {
		Set<EspecialidadeMedica> especialidadesNoBD = new HashSet<EspecialidadeMedica>();
		Iterator<EspecialidadeMedica> conjunto = especialidades.iterator();
		while (conjunto.hasNext()) {
			especialidadesNoBD.add(especialidadeMedicaService.addEspecialidadeMedica(conjunto.next()));
		}
		return especialidadesNoBD;
	}
	
	@Override
	public List<UnidadeDeSaude> findByBairro(String bairro) throws UnidadeSaudeException {
		List<UnidadeDeSaude> unidadesComMesmoBairro = buildListByBairro(bairro);
		findByBairroException(unidadesComMesmoBairro);
		return unidadesComMesmoBairro;
	}
	
	private List<UnidadeDeSaude> buildListByBairro(String bairro) throws UnidadeSaudeException {
		List<UnidadeDeSaude> unidadesComMesmoBairro = new ArrayList<>();
		for(UnidadeDeSaude unidade: findAll()) {
			if(unidade.getEndereco().getBairro().equals(bairro))
				unidadesComMesmoBairro.add(unidade);
		}
		return unidadesComMesmoBairro;
	}
	
	private void findByBairroException(List<UnidadeDeSaude> unidades) throws UnidadeSaudeException {
		if(unidades.isEmpty())
			throw new UnidadeSaudeException("Nao existem unidades de saude nesse bairro.");
	}

	@Override
	public UnidadeDeSaude delete(UnidadeDeSaude unidade) {
		UnidadeDeSaude unidadeResult = unidadeSaudeRepository.findOne(unidade.getId());
		unidadeSaudeRepository.delete(unidadeResult);
		return unidadeResult;
	}

	@Override
	public UnidadeDeSaude delete(Long unidadeId) {
		UnidadeDeSaude unidadeResult = unidadeSaudeRepository.findOne(unidadeId);
		unidadeSaudeRepository.delete(unidadeResult);
		return unidadeResult;
	}

	@Override
	public UnidadeDeSaude findById(Long unidadeId) throws ObjetoInexistenteException {
		UnidadeDeSaude unidade = unidadeSaudeRepository.findOne(unidadeId);
		if(unidade == null) 
			throw new ObjetoInexistenteException("Unidade de saude with " + unidadeId + " not found");
		return unidade;
	}

	@Override
	public List<UnidadeDeSaude> findAll() {
		return unidadeSaudeRepository.findAll();
	}

	/**
	 * Realiza busca da unidade de saude com a id passada como argumento e verifica
	 * sua existencia no repositorio, garantindo acesso apenas aos objetos nao
	 * nulos. Adiciona a especialidade medica atraves da service EspecialidadeMedica
	 * que retorna o objeto inserido no banco de dados e realiza a insercao na
	 * unidade de saude em questao, salvando-a e retornando com os dados
	 * atualizados.
	 */
	@Override
	public UnidadeDeSaude addEspecialidadeMedica(Long unidadeDeSaudeId, EspecialidadeMedica especialidade) throws UnidadeSaudeException {
		UnidadeDeSaude unidadeDeSaudeNoBD = findUnidadeDeSaudeException(unidadeDeSaudeId);
		EspecialidadeMedica especialidadeNoBD = findEspecialidadeMedicaException(unidadeDeSaudeNoBD, especialidade);
		saveEspecialidadeMedicaNaUnidadeDeSaude(unidadeDeSaudeNoBD, especialidadeNoBD);
		return unidadeDeSaudeNoBD;
	}
	
	private UnidadeDeSaude findUnidadeDeSaudeException(Long unidadeDeSaudeId) throws UnidadeSaudeException {
		UnidadeDeSaude unidadeDeSaudeNoBD = unidadeSaudeRepository.findOne(unidadeDeSaudeId);
		if (unidadeDeSaudeNoBD == null)
			throw new UnidadeSaudeException("Unidade de Saude inexistente.");
		return unidadeDeSaudeNoBD;
	}
	
	private EspecialidadeMedica findEspecialidadeMedicaException(UnidadeDeSaude unidadeDeSaudeNoBD,
			EspecialidadeMedica especialidade) throws UnidadeSaudeException {
		EspecialidadeMedica especialidadeNoBD = especialidadeMedicaService.addEspecialidadeMedica(especialidade);
		if (unidadeDeSaudeNoBD.getEspecialidadesMedicas().contains(especialidade))
			throw new UnidadeSaudeException("Essa unidade de Saude ja possui esta especialidade.");
		return especialidadeNoBD;
	}
	
	private void saveEspecialidadeMedicaNaUnidadeDeSaude(UnidadeDeSaude unidade, EspecialidadeMedica especialidade) {
		unidade.addEspecialidadeMedica(especialidade);
		unidadeSaudeRepository.save(unidade);
	}

	@Override
	public List<UnidadeDeSaude> findByEspecialidade(EspecialidadeMedica especialidade) {
		List<UnidadeDeSaude> unidades = unidadeSaudeRepository.findAll();
		List<UnidadeDeSaude> unidadesComMesmaEspecialidade = new ArrayList<>();
		for(UnidadeDeSaude u : unidades) {
			if(u.getEspecialidadesMedicas().contains(especialidade)) unidadesComMesmaEspecialidade.add(u);
		}
		return unidadesComMesmaEspecialidade;
	}
	
}