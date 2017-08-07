package com.ufcg.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ufcg.si1.factory.FactoryEndereco;
import com.ufcg.si1.model.Pessoa;
import com.ufcg.si1.model.Queixa;

public class QueixaServiceImplTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	private static List<Queixa> populateDummyQueixas() {
		List<Queixa> queixas = new ArrayList<Queixa>();

		queixas.add(new Queixa(counter.incrementAndGet(), "Passei mal com uma coxinha",
				new Pessoa("Jose Silva", "jose@gmail.com"), FactoryEndereco.buildEndereco("rua dos tolos", "PE", "Recife")));

		queixas.add(new Queixa(counter.incrementAndGet(), "Bacalhau estragado",
				new Pessoa("Ailton Sousa", "ailton@gmail.com"), FactoryEndereco.buildEndereco("rua dos bobos", "PB", "Joao Pessoa")));

		queixas.add(new Queixa(counter.incrementAndGet(), "Nossa rua estah muito suja",
				new Pessoa("Jose Silva", "jose@gmail.com"), FactoryEndereco.buildEndereco("rua dos tolos", "PE", "Recife")));

		queixas.add(new Queixa(counter.incrementAndGet(), "iluminacao horrivel, muitos assaltos",
				new Pessoa("Ailton Sousa", "ailton@gmail.com"), FactoryEndereco.buildEndereco("rua dos bobos", "PB", "Joao Pessoa")));

		return queixas;
	}

}
