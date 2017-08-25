package com.ufcg.si1.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_hospital")
public class Hospital extends UnidadeDeSaude implements Serializable {
	
	private static final long serialVersionUID = 4869314027333613155L;

}
