package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NumeroAvaliacao {

	PRIMEIRA(1, "1ª"),
	SEGUNDA(2, "2ª"),
	TERCEIRA(3, "3ª"),
	QUARTA(4, "4ª"),
	QUINTA(5, "5ª");
	
	private int codigo;
	private String descricao;
	
	public static NumeroAvaliacao toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (NumeroAvaliacao x : NumeroAvaliacao.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
