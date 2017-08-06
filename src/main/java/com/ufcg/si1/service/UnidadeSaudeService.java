package com.ufcg.si1.service;

import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.List;

import com.ufcg.si1.model.UnidadeSaude;


public interface UnidadeSaudeService {
    Object procura(int codigo) throws ObjetoInexistenteException;

    List<UnidadeSaude> getAll();

    void insere(UnidadeSaude us)throws ObjetoJaExistenteException;

    boolean existe(long codigo);

    UnidadeSaude findById(long id) throws ObjetoInexistenteException;

    UnidadeSaude findByBairro(String bairro) throws ObjetoInexistenteException;
}
