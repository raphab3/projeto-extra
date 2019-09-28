package com.databuilder.com.br.abcdata.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.databuilder.com.br.abcdata.entity.Login;
import com.databuilder.com.br.abcdata.entity.enums.NivelDeAcesso;
import com.databuilder.com.br.abcdata.entity.enums.StatusLogin;
import com.databuilder.com.br.abcdata.services.validation.LoginUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@LoginUpdate
public class LoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preeenchimento Obrigatório")
	@Length(min=5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
	private String email;
	@NotEmpty(message="Preeenchimento Obrigatório")
	@Length(min=5, max=200, message="O tamanho deve ser entre 5 e 200 caracteres")
	private String senha;
	@NotEmpty(message="Preeenchimento Obrigatório")
	@Length(min=5, max=200, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataCadastro;
	private StatusLogin statusLogin;
	private Integer tentativasDeAcesso;
	private NivelDeAcesso nivelDeAcesso;

	public LoginDTO(Login obj) {

		id = obj.getId();
		email = obj.getEmail();
		senha = obj.getSenha();
		nome = obj.getNomeUsuario();
		dataCadastro = obj.getDataCadastro();
		statusLogin = obj.getStatusLogin();
		tentativasDeAcesso = obj.getTentativasDeAcesso();
		nivelDeAcesso = obj.getNivelDeAcesso();
	}

	public Integer getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public StatusLogin getStatusLogin() {
		return statusLogin;
	}

	public Integer getTentativasDeAcesso() {
		return tentativasDeAcesso;
	}

	public NivelDeAcesso getNivelDeAcesso() {
		return nivelDeAcesso;
	}
	
}
