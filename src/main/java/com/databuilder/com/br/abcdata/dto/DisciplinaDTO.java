package com.databuilder.com.br.abcdata.dto;

import java.io.Serializable;

import com.databuilder.com.br.abcdata.entity.Disciplina;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DisciplinaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String disciplina;
	private Integer cargaHoraria;
	
	public DisciplinaDTO(Disciplina obj) {
		id = obj.getId();
		disciplina = obj.getDisciplina();
		cargaHoraria = obj.getCargaHoraria();
	}
	
}
