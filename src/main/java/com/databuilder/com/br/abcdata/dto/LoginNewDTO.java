package com.databuilder.com.br.abcdata.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
public class LoginNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String email;
	private String nome;
	private String senha;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataDeNascimento;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataCadastro;
	private Integer statusUsuario;
	private Integer tentativasDeAcesso;
	private Integer nivelDeAcesso;

}
