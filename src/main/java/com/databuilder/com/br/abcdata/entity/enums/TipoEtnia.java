package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoEtnia {

	BRANCA(1, "Branca"),
	NEGRA(2, "Negra"),
	PARDA(3, "Parda"),
	AMARELA(4, "Amarela"),
	INDIGENA(5, "Indigena");
	
	private int codigo;
	private String descricao;
	
	public static TipoEtnia toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoEtnia x : TipoEtnia.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
