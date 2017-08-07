package com.ufcg.si1.service;

import com.ufcg.si1.model.UnidadeSaude;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("unidadeSaudeService")
public class UnidadeSaudeServiceImpl implements UnidadeSaudeService {
	private List<UnidadeSaude> vetor;

    public UnidadeSaudeServiceImpl() {
        vetor = new ArrayList<>();
    }


    @Override
    public Object procura(int codigo) throws ObjetoInexistenteException {
        for (UnidadeSaude unidadeSaude : vetor) {
			if (unidadeSaude.getId() == codigo) {
				return unidadeSaude;
			}
		}
        throw new ObjetoInexistenteException("Não achou unidade");
    }

    @Override
    public List<UnidadeSaude> getAll() {
        return this.vetor;
    }

    @Override
	public void insere(UnidadeSaude us) throws ObjetoJaExistenteException {
		if (this.vetor.contains(us)) {
			throw new ObjetoJaExistenteException("Unidade ja cadastrada");
		}else {
			this.vetor.add(us);
		}
    }

    @Override
    public boolean existe(long codigo) {
        for (UnidadeSaude unidadeSaude : vetor) {
			if (unidadeSaude.getId() == codigo) {
				return true;
			}
		}
        return false;
    }

    public UnidadeSaude findById(long id) throws ObjetoInexistenteException {
        for (UnidadeSaude unidadeSaude : vetor) {
			if (unidadeSaude.getId() == id) {
				return unidadeSaude;
			}
		}
        throw new ObjetoInexistenteException("Naõ existe uma unidade de saude cadastrada com esse id");
    }

    @Override
    public UnidadeSaude findByBairro(String bairro) throws ObjetoInexistenteException {
        for (UnidadeSaude unidadeSaude : vetor) {
			if (unidadeSaude.getDescricao().equals(bairro)) {
				return unidadeSaude;
			}
		}
        throw new ObjetoInexistenteException("Não existe uma unidade de saude nesse bairro");
    }
}
