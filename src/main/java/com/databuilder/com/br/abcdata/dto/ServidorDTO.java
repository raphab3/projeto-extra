package com.databuilder.com.br.abcdata.dto;

import java.io.Serializable;

import com.databuilder.com.br.abcdata.entity.Servidor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ServidorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer matricula;
	private String nome;
	private String cpf;
	private Integer genero;
	private Integer etnia;
	private String nacionalidade;
	
	public ServidorDTO(Servidor obj) {
		
		id = obj.getId();
		matricula = obj.getMatricula();
		nome = obj.getNome();
		cpf = obj.getCpf();
		genero = obj.getGenero();
		etnia = obj.getEtnia();
		nacionalidade = obj.getNacionalidade();
	}
	
}
