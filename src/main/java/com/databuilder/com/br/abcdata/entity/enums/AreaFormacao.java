package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AreaFormacao {

	EDUCACAO(1, "Educação"),
	HUMANIDADES_E_ARTES(2, "Humanidades e Artes"),
	CIENCIAS_SOCIAIS_NEG_DIRE(3, "Ciências Sociais, Negócios e Direito"),
	CIENCIAS_MAT_COMPU(4, "Ciências, Matemática e Computação"),
	ENGENHARIA_PROD_CONSTR(5, "Engenharia, Produção e Construção"),
	AGRICULTURA_VETERINARIA(6, "Agricultura e Veterinária"),
	SAUDE_BEMESTARSOCIAL(7, "Saúde e Bem-Estar Social"),
	SERVICOS(7, "Serviços");
	
	private int codigo;
	private String descricao;
	
	public static AreaFormacao toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (AreaFormacao x : AreaFormacao.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
