package com.databuilder.com.br.abcdata.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@NoArgsConstructor
@Entity
@Table(name="unidade_educacional")
@Getter 
@Setter
@EqualsAndHashCode
public class UnidadeEducacional implements Serializable {

	private static final long serialVersionUID = 5914356445552675840L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigoInep;
	private String unidadeEducacional;
	
	public UnidadeEducacional(Integer id, String codigoInep, String unidadeEducacional) {
		super();
		this.id = id;
		this.codigoInep = codigoInep;
		this.unidadeEducacional = unidadeEducacional;
	}

}
