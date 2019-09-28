package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NivelFormacao {

	GRADUCAO(1, "Graduação"),
	ESPECIALIZACAO(2, "Especialização"),
	MESTRADO(3, "Mestrado"),
	DOUTORADO(4, "Doutorado"),
	POS_DOUTORADO(5, "Pós Doutorado"),
	COMPLEMENTAR(6, "Complementar"),
	TECNICO(7, "Técnico"),
	MEDIO(8, "Médio");
	
	private int codigo;
	private String descricao;
	
	public static NivelFormacao toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (NivelFormacao x : NivelFormacao.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
