package com.ufcg.si1.service;


import java.util.Iterator;
import java.util.List;

import com.ufcg.si1.model.Queixa;

import exceptions.ObjetoInexistenteException;

public interface QueixaService {

	List<Queixa> findAllQueixas();

    void saveQueixa(Queixa queixa);

	Queixa findById(long id) throws ObjetoInexistenteException;

	void deleteQueixaById(long id);

    int size();

	Iterator<Queixa> getIterator();


//	boolean isUserExist(Queixa user);
	
}
