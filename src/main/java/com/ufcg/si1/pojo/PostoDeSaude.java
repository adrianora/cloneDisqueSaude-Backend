package com.ufcg.si1.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_postosaude")
public class PostoDeSaude extends UnidadeDeSaude implements Serializable {

	private static final long serialVersionUID = 5000093145633078354L;
	
}
