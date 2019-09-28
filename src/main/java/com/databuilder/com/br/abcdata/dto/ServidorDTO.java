package com.databuilder.com.br.abcdata.dto;

import java.io.Serializable;
import java.util.Date;

import com.databuilder.com.br.abcdata.entity.Servidor;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ServidorDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataCadastro;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataUltimaAlteracao;
	private Integer matricula;
	private String nome;
	private String nomeSocial;
	private String cpf;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataNascimento;
	private Integer genero;
	private Integer etnia;
	private String nacionalidade;
	
	public ServidorDTO(Servidor obj) {
		
		id = obj.getId();
		dataCadastro = obj.getDataCadastro();
		dataUltimaAlteracao = obj.getDataUltimaAlteracao();
		matricula = obj.getMatricula();
		nome = obj.getNome();
		nomeSocial = obj.getNomeSocial();
		cpf = obj.getCpf();
		dataNascimento = obj.getDataNascimento();
		genero = obj.getGenero();
		etnia = obj.getEtnia();
		nacionalidade = obj.getNacionalidade();
	}
	
}
