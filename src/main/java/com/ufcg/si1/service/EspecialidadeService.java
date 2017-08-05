package com.ufcg.si1.service;

import com.ufcg.si1.model.EspecialidadeMedica;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import exceptions.Rep;

import java.util.List;


public interface EspecialidadeService {
    EspecialidadeMedica procura(int codigo) throws Rep,
            ObjetoInexistenteException;

    List getListaEspecialidade()
                    throws Rep, ObjetoInexistenteException;

    int size();

    EspecialidadeMedica getElemento(int posicao);

    void insere(EspecialidadeMedica esp)throws Rep,
            ObjetoJaExistenteException;

    boolean existe(int codigo);

    EspecialidadeMedica findById(long id);
}
