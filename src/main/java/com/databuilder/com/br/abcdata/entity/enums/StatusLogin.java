package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusLogin {

	ATIVO(1, "Ativo"),
	INATIVO(2, "Inativo"),
	BLOQUEADO(3, "Bloqueado");
	
	private int codigo;
	private String descricao;
	
	public static StatusLogin toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (StatusLogin x : StatusLogin.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
