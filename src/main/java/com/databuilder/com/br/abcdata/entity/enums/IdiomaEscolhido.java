package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum IdiomaEscolhido {

	INGLES(1, "Ingles"),
	ESPANHOL(2, "Espanhol"),
	FRANCES(3, "Francês");
	
	private int codigo;
	private String descricao;
	
	public static IdiomaEscolhido toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (IdiomaEscolhido x : IdiomaEscolhido.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
