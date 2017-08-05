package com.ufcg.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.si1.model.Endereco;

public class EnderecoTest {
	
	private ArrayList<Endereco> enderecos;
	
	public EnderecoTest() {
		this.enderecos = new ArrayList<Endereco>();
	}
	
	@Before
	public void setUp() {
		addEnderecoTest();
	}
	
	private void addEnderecoTest() {
		this.enderecos.add(new Endereco("Av .Alm Barroso", "PB", "Campina Grande"));
		this.enderecos.add(new Endereco("Av. Mal. Floriano Peixoto", "PB", "Campina Grande"));
		this.enderecos.add(new Endereco("Av. Paulista", "SP", "São Paulo"));
	}
	
	@Test
	public void nomeEnderecoTest() {
		assertEquals("Av .Alm Barroso", this.enderecos.get(0).getRua());
		assertEquals("Av. Mal. Floriano Peixoto", this.enderecos.get(1).getRua());
		assertEquals("Av. Paulista", this.enderecos.get(2).getRua());
	}

	@Test
	public void ufEnderecoTest() {
		assertEquals("PB", this.enderecos.get(0).getUf());
		assertEquals("PB", this.enderecos.get(1).getUf());
		assertEquals("SP", this.enderecos.get(2).getUf());
	}
	
	@Test
	public void cidadeEnderecoTest() {
		assertEquals("Campina Grande", this.enderecos.get(0).getCidade());
		assertEquals("Campina Grande", this.enderecos.get(1).getCidade());
		assertEquals("São Paulo", this.enderecos.get(2).getCidade());
	}
	
	@Test
	public void nullObjectEnderecoTest() {
		this.enderecos.add(new Endereco());
		assertTrue(this.enderecos.get(3).getRua() == null);
		assertTrue(this.enderecos.get(3).getUf() == null);
		assertTrue(this.enderecos.get(3).getCidade() == null);
	}
	
	@Test
	public void nullSettersEnderecoTest() {
		this.enderecos.add(new Endereco());
		this.enderecos.get(3).setRua("Rua inserida com setter");
		this.enderecos.get(3).setUf("Uf inserida com setter");
		this.enderecos.get(3).setCidade("Cidade inserida com setter");
		assertEquals("Rua inserida com setter", this.enderecos.get(3).getRua());
		assertEquals("Uf inserida com setter", this.enderecos.get(3).getUf());
		assertEquals("Cidade inserida com setter", this.enderecos.get(3).getCidade());
	}
	
}
