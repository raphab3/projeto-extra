package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoRede {

	MUNICIPAL(1, "Municipal"),
	ESTADUAL(2, "Estadual"),
	FEDERAL(3, "Federal"),
	PRIVADA(4, "Privada");
	
	private int codigo;
	private String descricao;
	
	public static TipoRede toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoRede x : TipoRede.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
