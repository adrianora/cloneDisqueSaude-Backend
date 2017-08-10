package com.ufcg.si1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tb_hospital")
public class Hospital extends UnidadeDeSaude implements Serializable {

	private static final long serialVersionUID = 4869314027333613155L;
	
	@Transient
	private br.edu.ufcg.Hospital hospital;

	public Hospital(String descricao, int medicos, int numeroPacientesDia) {
		super(descricao);
		this.hospital = new br.edu.ufcg.Hospital(descricao, medicos, numeroPacientesDia);
	}

	public Hospital() {
		super();
		this.hospital = new br.edu.ufcg.Hospital(null, 0, 0);
	}

	public int getAtendentes() {
		return this.hospital.getNumeroMedicos();
	}

	public void setAtendentes(int atendentes) {
		this.hospital.setNumeroMedicos(atendentes);
	}

	public int getTaxaDiariaAtendimento() {
		return (int) this.hospital.getNumeroPacientesDia();
	}

	public void setTaxaDiariaAtendimento(int taxaDiariaAtendimento) {
		this.hospital.setNumeroPacientesDia(taxaDiariaAtendimento);
	}

}
