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
	
	public Hospital() {
		super();
		super.setAtendentes(0);
		super.setTaxaDiariaAtendimento(0);
		this.hospital = new br.edu.ufcg.Hospital(null, 0, 0);
	}

	public Hospital(String bairro, int medicos, int numeroPacientesDia) {
		super(bairro);
		super.setAtendentes(medicos);
		super.setTaxaDiariaAtendimento(numeroPacientesDia);
		this.hospital = new br.edu.ufcg.Hospital(bairro, medicos, numeroPacientesDia);
	}

	public int getAtendentes() {
		return super.getAtendentes();
		// return this.hospital.getNumeroMedicos();
	}

	public void setAtendentes(int atendentes) {
		super.setAtendentes(atendentes);
		this.hospital.setNumeroMedicos(atendentes);
	}

	public int getTaxaDiariaAtendimento() {
		return super.getTaxaDiariaAtendimento();
		// return (int) this.hospital.getNumeroPacientesDia();
	}

	public void setTaxaDiariaAtendimento(int taxaDiariaAtendimento) {
		super.setTaxaDiariaAtendimento(taxaDiariaAtendimento);
		this.hospital.setNumeroPacientesDia(taxaDiariaAtendimento);
	}

}
