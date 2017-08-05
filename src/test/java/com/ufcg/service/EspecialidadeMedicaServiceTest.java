package com.ufcg.service;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.si1.model.EspecialidadeMedica;
import com.ufcg.si1.service.EspecialidadeMedicaServiceImpl;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;

public class EspecialidadeMedicaServiceTest {
	
	private EspecialidadeMedicaServiceImpl esp;

	@Before
	public void setUp() {
		esp = new EspecialidadeMedicaServiceImpl();
	}
	
	@Test
	private void testInsere() throws ObjetoJaExistenteException, ObjetoInexistenteException {
		esp.insereEspecialidade(new EspecialidadeMedica("pediatria"));
		esp.insereEspecialidade(new EspecialidadeMedica("oncologia"));
		esp.insereEspecialidade(new EspecialidadeMedica("oftamologia"));
	}

}
