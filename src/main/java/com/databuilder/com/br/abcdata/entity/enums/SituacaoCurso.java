package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SituacaoCurso {

	CONCLUIDO(1, "Concluído"),
	EM_CURSO(2, "Em Andamento"),
	TRANCADO(3, "Trancado");
	
	private int codigo;
	private String descricao;
	
	public static SituacaoCurso toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (SituacaoCurso x : SituacaoCurso.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
