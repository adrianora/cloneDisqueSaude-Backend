package com.ufcg.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.si1.pojo.EspecialidadeMedica;

public class EspecialidadeMedicaTest {
	
	private ArrayList<EspecialidadeMedica> especialidades;
	
	public EspecialidadeMedicaTest() {
		this.especialidades = new ArrayList<EspecialidadeMedica>();
	}
	
	@Before
	public void setUp() {
		addEspecialidadesTest();
	}
	
	private void addEspecialidadesTest() {
		this.especialidades.add(new EspecialidadeMedica("Cardiologista"));
		this.especialidades.add(new EspecialidadeMedica("Cirurgião Geral"));
		this.especialidades.add(new EspecialidadeMedica("Infecologista"));
		this.especialidades.add(new EspecialidadeMedica("Pediatra"));
	}
	
	@Test
	public void descricaoEspecialidadeTest() {
		assertEquals("Cardiologista", this.especialidades.get(0).getDescricao());
		assertEquals("Cirurgião Geral", this.especialidades.get(1).getDescricao());
		assertEquals("Infecologista", this.especialidades.get(2).getDescricao());
		assertEquals("Pediatra", this.especialidades.get(3).getDescricao());
	}
	
	@Test
	public void nullObjectPessoaTest() {
		this.especialidades.add(new EspecialidadeMedica());
		assertTrue(this.especialidades.get(4).getDescricao() == null);
	}
	
	@Test
	public void nullSettersPessoaTest() {
		this.especialidades.add(new EspecialidadeMedica());
		assertTrue(this.especialidades.get(4).getDescricao() == null);
		this.especialidades.get(4).setDescricao("Descrição adicionada com setter");
		assertEquals("Descrição adicionada com setter", this.especialidades.get(4).getDescricao());
	}

}
