package com.ufcg.si1.service;

import com.ufcg.si1.model.Queixa;

import exceptions.ObjetoInexistenteException;

import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service("queixaService")
public class QueixaServiceImpl implements QueixaService {

	private static List<Queixa> queixas;

	public List<Queixa> findAllQueixas() {
		return queixas;
	}

	public void saveQueixa(Queixa queixa) {
		queixas.add(queixa);
	}
	
	public void deleteQueixaById(long id) {

		for (Iterator<Queixa> iterator = queixas.iterator(); iterator.hasNext();) {
			Queixa q = iterator.next();
			if (q.getId() == id) {
				iterator.remove();
			}
		}
	}

	@Override
	public int size() {
		return queixas.size();
	}

	@Override
	public Iterator<Queixa> getIterator() {
		return queixas.iterator();
	}

	public void deleteAllUsers() {
		queixas.clear();
	}

	public Queixa findById(long id) throws ObjetoInexistenteException {
		for (Queixa queixa : queixas) {
			if (queixa.getId() == id) {
				return queixa;
			}
		}
		throw new ObjetoInexistenteException("Não existe uma queixa com esse id");
	}

}
