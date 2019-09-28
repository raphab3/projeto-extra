package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoEnsino {

	BASICO(1, "Básico"),
	INFANTIL(2, "Infantil"),
	FUNDAMENTAL(3, "Fundamental"),
	MEDIO(4, "Médio"),
	TECNICO(5, "Técnico");
	
	private int codigo;
	private String descricao;
	
	public static TipoEnsino toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoEnsino x : TipoEnsino.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
