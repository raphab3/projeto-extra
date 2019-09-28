package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoServidor {

	ADMINISTRATIVO(1, "Administrativo"),
	PEDAGOGICO(2, "Pedagógico"),
	PROFESSOR(3, "Professor");
	
	private int codigo;
	private String descricao;
	
	public static TipoServidor toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (TipoServidor x : TipoServidor.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
