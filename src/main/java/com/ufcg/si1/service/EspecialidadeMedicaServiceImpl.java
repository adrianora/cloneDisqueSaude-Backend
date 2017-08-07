package com.ufcg.si1.service;

import com.ufcg.si1.model.EspecialidadeMedica;
import exceptions.ObjetoInexistenteException;
import exceptions.ObjetoJaExistenteException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("especialidadeService")
public class EspecialidadeMedicaServiceImpl implements EspecialidadeMedicaService {

    private List<EspecialidadeMedica> especialidades;

    public EspecialidadeMedicaServiceImpl() {
    	
        this.especialidades = new ArrayList<>();
    }

    @Override
    public EspecialidadeMedica procura(long codigo) throws ObjetoInexistenteException {
    	
        for (EspecialidadeMedica especialidade: especialidades) {
        	
			if(especialidade.getId() == codigo) {
				
				return especialidade;
			}
		}
        throw new ObjetoInexistenteException("Especialidade inexistente.");
    }

    @Override
    public List<EspecialidadeMedica> getListaEspecialidade() {
    	
        return this.especialidades;
    }

    @Override
    public int size() {
    	
        return this.especialidades.size();
    }

    @Override
    public EspecialidadeMedica getEspecialidade(int posicao) throws ObjetoInexistenteException {
    	
    	EspecialidadeMedica elemento = this.especialidades.get(posicao); 
    	
        if (elemento != null) {
        	
        	return elemento; 
        }
        else {
        	
        	throw new ObjetoInexistenteException("Essa especialidade não existe");
        }
    }

    @Override
    public void insereEspecialidade(EspecialidadeMedica esp) throws ObjetoJaExistenteException, ObjetoInexistenteException {
     
    	if (this.contains(esp.getId())) {
        
    		throw new ObjetoJaExistenteException("Especialidade já existe na lista");
        }else {
        
        	this.especialidades.add(esp);
        }
    }

    @Override
    public boolean contains(long codigo) throws ObjetoInexistenteException {
    	
    	return this.especialidades.contains(procura(codigo));
    }

    public EspecialidadeMedica findById(long id) throws ObjetoInexistenteException {
       
    	EspecialidadeMedica esp = procura(id);
        return esp;
    }


}
