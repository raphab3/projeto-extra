package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoNota {

	AVALIACAO(1, "Avaliação"),
	RECUPERACAO(2, "Recuperação"),
	FINAL(2, "Final");
	
	private int codigo;
	private String descricao;
	
	public static TipoNota toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoNota x : TipoNota.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
