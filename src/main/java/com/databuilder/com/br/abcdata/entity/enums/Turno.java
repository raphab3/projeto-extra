package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Turno {

	MANHA(1, "Manha"),
	TARDE(2, "Tarde"),
	NOITE(3, "Noite"),
	INTEGRAL(4, "Integral");
	
	private int codigo;
	private String descricao;
	
	public static Turno toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (Turno x : Turno.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
