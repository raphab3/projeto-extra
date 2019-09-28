package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoGenero {

	MASCULINO(1, "Masculino"),
	FEMININO(2, "Feminino");
	
	private int codigo;
	private String descricao;
	
	public static TipoGenero toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoGenero x : TipoGenero.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
