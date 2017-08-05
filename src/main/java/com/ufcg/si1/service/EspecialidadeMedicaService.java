package com.ufcg.si1.service;

import com.ufcg.si1.model.EspecialidadeMedica;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.List;


public interface EspecialidadeMedicaService {
    EspecialidadeMedica procura(long codigo) throws ObjetoInexistenteException;

    List<EspecialidadeMedica> getListaEspecialidade();

    int size();

    EspecialidadeMedica getEspecialidade(int posicao) throws ObjetoInexistenteException;

    void insereEspecialidade(EspecialidadeMedica esp)throws ObjetoJaExistenteException, ObjetoInexistenteException;

    boolean contains(long codigo) throws ObjetoInexistenteException;

    EspecialidadeMedica findById(long id) throws ObjetoInexistenteException;
}
