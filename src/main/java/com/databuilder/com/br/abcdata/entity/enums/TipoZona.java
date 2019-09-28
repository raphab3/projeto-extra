package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoZona {

	URBANA(1, "Urbana"),
	RURAL(2, "Rural");
	
	private int codigo;
	private String descricao;
	
	public static TipoZona toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoZona x : TipoZona.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
