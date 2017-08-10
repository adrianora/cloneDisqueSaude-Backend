package com.ufcg.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.si1.model.EspecialidadeMedica;
import com.ufcg.si1.model.Hospital;
import com.ufcg.si1.model.PostoDeSaude;
import com.ufcg.si1.model.UnidadeDeSaude;

public class UnidadeSaudeTest {
	
	private ArrayList<PostoDeSaude> postos;
	private ArrayList<Hospital> hospitais;
	private ArrayList<EspecialidadeMedica> especialidades;
	
	public UnidadeSaudeTest() {
		this.postos = new ArrayList<PostoDeSaude>();
		this.hospitais = new ArrayList<Hospital>();
		this.especialidades = new ArrayList<EspecialidadeMedica>();
	}
	
	@Before
	public void setUp() {
		addPostosDeSaudeTest();
		addHospitaisTest();
		addEspecialidadesTest();
	}
	
	private void addPostosDeSaudeTest() {
		this.postos.add(new PostoDeSaude("Monte Santo", 10, 15));
		this.postos.add(new PostoDeSaude("Palmeira", 9, 21));
		this.postos.add(new PostoDeSaude("Liberdade", 21, 36));
		this.postos.add(new PostoDeSaude("Catolé", 16, 11));
	}
	
	private void addHospitaisTest() {
		this.hospitais.add(new Hospital("FAP", 121, 231));
		this.hospitais.add(new Hospital("Trauma", 161, 512));
		this.hospitais.add(new Hospital("João XXIII", 172, 216));
		this.hospitais.add(new Hospital("Antônio Targino", 132, 431));
	}
	
	private void addEspecialidadesTest() {
		this.especialidades.add(new EspecialidadeMedica("Cardiologista"));
		this.especialidades.get(0).setId(0L);
		this.especialidades.add(new EspecialidadeMedica("Cirurgião Geral"));
		this.especialidades.get(1).setId(1L);
		this.especialidades.add(new EspecialidadeMedica("Infecologista"));
		this.especialidades.get(2).setId(2L);
		this.especialidades.add(new EspecialidadeMedica("Pediatra"));
		this.especialidades.get(3).setId(3L);
	}
	
	@Test
	public void hospitalTest() {
		assertEquals("FAP", this.hospitais.get(0).getDescricao());
		assertEquals(121, this.hospitais.get(0).getAtendentes());
		assertEquals(231, this.hospitais.get(0).getTaxaDiariaAtendimento());
		this.hospitais.get(0).setId(262L);
		assertEquals(new Long(262), this.hospitais.get(0).getId());
		this.hospitais.get(0).setAtendentes(12);
		assertEquals(12, this.hospitais.get(0).getAtendentes());
		this.hospitais.get(0).setTaxaDiariaAtendimento(24);
		assertEquals(24, this.hospitais.get(0).getTaxaDiariaAtendimento());
	}
	
	@Test
	public void postoDeSaudeTest() {
		assertEquals("Monte Santo", this.postos.get(0).getDescricao());
		assertEquals(10, this.postos.get(0).getAtendentes());
		assertEquals(15, this.postos.get(0).getTaxaDiariaAtendimento());
		this.postos.get(0).setId(262L);
		assertEquals(new Long(262), this.postos.get(0).getId());
		this.postos.get(0).setAtendentes(12);
		assertEquals(12, this.postos.get(0).getAtendentes());
		this.postos.get(0).setTaxaDiariaAtendimento(24);
		assertEquals(24, this.postos.get(0).getTaxaDiariaAtendimento());
	}
	
	@Test
	public void chamadaPolimorficaTest() {
		ArrayList<UnidadeDeSaude> unidades = new ArrayList<UnidadeDeSaude>();
		unidades.addAll(this.hospitais);
		unidades.addAll(this.postos);
		assertTrue(unidades.size() == 8);
		for (int index = 0; index < 4; index++)
			assertTrue(unidades.get(index).equals(this.hospitais.get(index)));
		int count = 0;
		for (int index = 4; index < unidades.size(); index++) {
			assertTrue(unidades.get(index).equals(this.postos.get(count++)));
		}
	}
	
	@Test
	public void nullObjectPostoDeSaudeTest() {
		this.postos.add(new PostoDeSaude());
		assertTrue(this.postos.get(4).getAtendentes() == 0);
		assertTrue(this.postos.get(4).getTaxaDiariaAtendimento() == 0);
		assertTrue(this.postos.get(4).getDescricao() == null);
		assertTrue(this.postos.get(4).getEspecialidadesMedicas().size() == 0);
	}
	
	@Test
	public void nullObjectHospitalTest() {
		this.hospitais.add(new Hospital());
		assertTrue(this.hospitais.get(4).getAtendentes() == 0);
		assertTrue(this.hospitais.get(4).getTaxaDiariaAtendimento() == 0);
		assertTrue(this.hospitais.get(4).getDescricao() == null);
		assertTrue(this.hospitais.get(4).getEspecialidadesMedicas().size() == 0);
	}
	
	@Test
	public void nullSettersPostoDeSaudeTest() {
		this.postos.add(new PostoDeSaude());
		this.postos.get(4).setAtendentes(50);
		assertTrue(this.postos.get(4).getAtendentes() == 50);
		this.postos.get(4).setTaxaDiariaAtendimento(21);
		assertTrue(this.postos.get(4).getTaxaDiariaAtendimento() == 21);
		this.postos.get(4).setDescricao("Descrição com setter");
		assertTrue(this.postos.get(4).getDescricao() == "Descrição com setter");
		assertTrue(this.postos.get(4).getEspecialidadesMedicas() != null);
	}

}
