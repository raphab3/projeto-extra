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

@Entity
@Table(name = "disciplina")
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String disciplina;
	private Integer cargaHoraria;

	public Disciplina(Integer id, String disciplina, Integer cargaHoraria) {
		super();
		this.id = id;
		this.disciplina = disciplina;
		this.cargaHoraria = cargaHoraria;
	}

}