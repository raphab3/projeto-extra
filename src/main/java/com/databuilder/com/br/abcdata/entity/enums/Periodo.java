package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Periodo {

	BIMESTRE_1(1, "1o BIMESTRE"),
	BIMESTRE_2(2, "2o BIMESTRE"),
	BIMESTRE_3(1, "3o BIMESTRE"),
	BIMESTRE_4(1, "4o BIMESTRE"),
	FINAL(1, "Final");
	
	private int codigo;
	private String descricao;
	
	public static Periodo toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (Periodo x : Periodo.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
