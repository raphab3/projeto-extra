package com.databuilder.com.br.abcdata.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum NivelDeAcesso {

	ADMIN(1, "ADMINISTRADOR"),
	GESTOR_GERAL(2, "GESTÃO GERAL"),
	GERENTE_NUCLEO(3, "GERENCIA DE NUCLEO"),
	DIRETOR_UN_EDUCACIONAL(4, "DIRETORIA DA UNIDADE EDUCACIONAL"),
	COORDENADOR_UN_EDUCACIONAL(5, "COORDENAÇÃO DA UNIDADE EDUCACIONAL"),
	SECRETARIA_UN_EDUCACIONAL(6, "SECRETARIA DA UNIDADE EDUCACIONAL"),
	PROFESSOR(7, "PROFESSOR"),
	ESTUDANTE(8, "ESTUDANTE");
	
	private int codigo;
	private String descricao;
	
	public static NivelDeAcesso toEnum(Integer codigo) {
		
		if (codigo == null) {
			return null;
		}
		for (NivelDeAcesso x : NivelDeAcesso.values()) {
			if(codigo.equals(x.getCodigo())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
