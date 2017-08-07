package com.ufcg.si1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TB_HOSPITAL")
public class Hospital extends UnidadeSaude implements Serializable {

	private static final long serialVersionUID = 4869314027333613155L;

	@Column(name = "hospital")
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

	public int getTaxaDiariaAtendimentos() {
		return (int) this.hospital.getNumeroPacientesDia();
	}

	public void setTaxaDiariaAtendimentos(int taxaDiariaAtendimentos) {
		this.hospital.setNumeroPacientesDia(taxaDiariaAtendimentos);
	}

}
