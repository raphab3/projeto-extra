package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum SituacaoEstudante {

	ATIVO(1, "Ativo"),
	DESISTENTE(2, "Desistente"),
	TRANSFERIDO(3, "Transferido");
	
	private int codigo;
	private String descricao;
	
	public static SituacaoEstudante toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (SituacaoEstudante x : SituacaoEstudante.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
