package com.ufcg.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.ufcg.si1.model.Endereco;
import com.ufcg.si1.model.Cidadao;
import com.ufcg.si1.model.Queixa;
import com.ufcg.si1.model.QueixaStatus;

import exceptions.ObjetoInvalidoException;

public class QueixaTest {
	
	private ArrayList<Cidadao> pessoas;
	private ArrayList<Endereco> enderecos;
	private ArrayList<Queixa> queixas;
	
	public QueixaTest() {
		this.pessoas = new ArrayList<Cidadao>();
		this.enderecos = new ArrayList<Endereco>();
		this.queixas = new ArrayList<Queixa>();
	}
	
	@Before
	public void setUp() {
		addPessoasTest();
		addEnderecoTest();
		//addQueixasTest();
	}
	
	private void addPessoasTest() {
		this.pessoas.add(new Cidadao("Adriano", "adriano@email.com"));
		this.pessoas.add(new Cidadao("Agnaldo", "agnaldo@email.com"));
		this.pessoas.add(new Cidadao("Rubens", "rubens@email.com"));
		this.pessoas.add(new Cidadao("Ronnyldo", "ronnyldo@email.com"));
	}
	
	private void addEnderecoTest() {
		this.enderecos.add(new Endereco("Av .Alm Barroso", "PB", "Campina Grande"));
		this.enderecos.add(new Endereco("Av. Mal. Floriano Peixoto", "PB", "Campina Grande"));
		this.enderecos.add(new Endereco("Av. Paulista", "SP", "São Paulo"));
		this.enderecos.add(new Endereco("Av .Assis Chateaubriand", "PB", "Campina Grande"));
	}
	
//	private void addQueixasTest() {
//		this.queixas.add(new Queixa("descricao", this.pessoas.get(0), this.enderecos.get(0)));
//		this.queixas.add(new Queixa("descricao", this.pessoas.get(1), this.enderecos.get(1)));
//		this.queixas.add(new Queixa("descricao", this.pessoas.get(2), this.enderecos.get(2)));
//		this.queixas.add(new Queixa("descricao", this.pessoas.get(3), this.enderecos.get(3)));
//		
//	}
	
	@Test
	public void getsQueixaTest() {
		assertEquals("Adriano", this.pessoas.get(0).getNome());
		assertEquals("Agnaldo", this.pessoas.get(1).getNome());
		assertEquals("Rubens", this.pessoas.get(2).getNome());
		assertEquals("Ronnyldo", this.pessoas.get(3).getNome());
	}

	@Test
	public void statusQueixaTest() {
		try {
			assertEquals(QueixaStatus.ABERTA, this.queixas.get(0).getSituacao());
			this.queixas.get(0).fechar("fechada para teste");
			assertEquals("fechada para teste", this.queixas.get(0).getComentario());
			assertEquals(QueixaStatus.FECHADA, this.queixas.get(0).getSituacao());
			this.queixas.get(0).abrir();
			assertEquals(QueixaStatus.ABERTA, this.queixas.get(0).getSituacao());
		} catch (ObjetoInvalidoException e) {
			e.getMessage();
		}
	}
	
	@Test(expected = ObjetoInvalidoException.class)
	public void statusAbrirExceptionQueixaTest() throws ObjetoInvalidoException {
		this.queixas.get(0).abrir();
	}
	
	@Test(expected = ObjetoInvalidoException.class)
	public void statusFecharExceptionQueixaTest() throws ObjetoInvalidoException {
		this.queixas.get(0).fechar("dummy");
		this.queixas.get(0).fechar("dummy");
	}
	
//	@Test
//	public void nullObjectQueixaTest() {
//		this.queixas.add(new Queixa());
//		assertTrue(this.queixas.get(4).getId() == null);
//		assertTrue(this.queixas.get(4).getDescricao() == null);
//		assertTrue(this.queixas.get(4).getSituacao() == QueixaStatus.ABERTA);
//		assertTrue(this.queixas.get(4).getSolicitante() == null);
//		assertTrue(this.queixas.get(4).getEndereco() == null);
//		assertTrue(this.queixas.get(4).getComentario() == null);
//	}
//	
//	@Test
//	public void nullSettersQueixaTest() {
//		this.queixas.add(new Queixa());
//		
//		this.queixas.get(4).setId(25L);
//		this.queixas.get(4).setSolicitante(this.pessoas.get(3));
//		this.queixas.get(4).setEndereco(this.enderecos.get(3));
//		this.queixas.get(4).setDescricao("Descrição inserida com setter");
//		this.queixas.get(4).setComentario("Comentário adicionado com setter");
//		
//		assertEquals(new Long(25), this.queixas.get(4).getId());
//		assertEquals(this.pessoas.get(3), this.queixas.get(4).getSolicitante());
//		assertEquals(this.enderecos.get(3), this.queixas.get(4).getEndereco());
//		assertEquals("Descrição inserida com setter", this.queixas.get(4).getDescricao());
//		assertEquals("Comentário adicionado com setter", this.queixas.get(4).getComentario());
//	}

}
