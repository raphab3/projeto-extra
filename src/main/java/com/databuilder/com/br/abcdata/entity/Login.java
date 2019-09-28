package com.databuilder.com.br.abcdata.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.databuilder.com.br.abcdata.entity.enums.NivelDeAcesso;
import com.databuilder.com.br.abcdata.entity.enums.PermissaoDeAcesso;
import com.databuilder.com.br.abcdata.entity.enums.StatusLogin;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@Entity
@Table(name = "login")
@Getter
@Setter
@EqualsAndHashCode
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


	@ApiModelProperty(notes = "The username parameter", required = true)
	@Column(name = "username", unique = true)
	private String email;
	
	private String nomeUsuario;

	@JsonIgnore
	@ApiModelProperty(notes = "The password parameter", required = true)
	@Column(name = "password", nullable = false, length = 200)
	private String senha;
	private Date dataCadastro;
	private Integer statusLogin;
	private Integer tentativasDeAcesso;

	private Integer nivelDeAcesso;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "permissao_de_acesso")
	private Set<Integer> permissoes = new HashSet<>();

	public Login() {
	//	addPermissao(PermissaoDeAcesso.CADASTRA_NUCLEO);
	}

	public Login(Integer id, String email, String nomeUsuario, String senha, Date dataCadastro, StatusLogin statusLogin,
			Integer tentativasDeAcesso, NivelDeAcesso nivelDeAcesso) {
		super();
		this.id = id;
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.statusLogin = statusLogin.getCodigo();
		this.tentativasDeAcesso = tentativasDeAcesso;
		this.nivelDeAcesso = nivelDeAcesso.getCodigo();
		
		// System.out.println(this.nivelDeAcesso);
		
		switch (this.nivelDeAcesso) {
		
		case 1:
			addPermissao(PermissaoDeAcesso.ADMIN);
			addPermissao(PermissaoDeAcesso.CADASTRA_ANO_LETIVO);
			addPermissao(PermissaoDeAcesso.PESQUISA_ANO_LETIVO);
			addPermissao(PermissaoDeAcesso.EDITA_ANO_LETIVO);
			addPermissao(PermissaoDeAcesso.REMOVE_ANO_LETIVO);
			addPermissao(PermissaoDeAcesso.CADASTRA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.PESQUISA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.EDITA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.REMOVE_AVALIACAO);
			addPermissao(PermissaoDeAcesso.CADASTRA_NUCLEO);
			addPermissao(PermissaoDeAcesso.PESQUISA_NUCLEO);
			addPermissao(PermissaoDeAcesso.REMOVE_NUCLEO);
			addPermissao(PermissaoDeAcesso.EDITA_NUCLEO);
			addPermissao(PermissaoDeAcesso.CADASTRA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.REMOVE_SERVIDOR);
			addPermissao(PermissaoDeAcesso.EDITA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.CADASTRA_UNIDADE_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.PESQUISA_UNIDADES_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.REMOVE_UNIDADES_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.EDITA_UNIDADES_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.CADASTRA_EVENTO);
			addPermissao(PermissaoDeAcesso.PESQUISA_EVENTO);
			addPermissao(PermissaoDeAcesso.REMOVE_EVENTO);
			addPermissao(PermissaoDeAcesso.EDITA_EVENTO);
			addPermissao(PermissaoDeAcesso.CADASTRA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.PESQUISA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.REMOVE_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.EDITA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.CADASTRA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.PESQUISA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.REMOVE_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.EDITA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.CADASTRA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.PESQUISA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.REMOVE_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.EDITA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.CADASTRA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.PESQUISA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.REMOVE_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.EDITA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.CADASTRA_LOGIN);
			addPermissao(PermissaoDeAcesso.PESQUISA_LOGIN);
			addPermissao(PermissaoDeAcesso.REMOVE_LOGIN);
			addPermissao(PermissaoDeAcesso.EDITA_LOGIN);
			addPermissao(PermissaoDeAcesso.CADASTRA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.REMOVE_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.EDITA_SERIE_TURMA);
			break;
			
		case 2:
			addPermissao(PermissaoDeAcesso.CADASTRA_ANO_LETIVO);
			addPermissao(PermissaoDeAcesso.PESQUISA_ANO_LETIVO);
			addPermissao(PermissaoDeAcesso.EDITA_ANO_LETIVO);
			addPermissao(PermissaoDeAcesso.REMOVE_ANO_LETIVO);
			addPermissao(PermissaoDeAcesso.CADASTRA_NUCLEO);
			addPermissao(PermissaoDeAcesso.PESQUISA_NUCLEO);
			addPermissao(PermissaoDeAcesso.REMOVE_NUCLEO);
			addPermissao(PermissaoDeAcesso.EDITA_NUCLEO);
			addPermissao(PermissaoDeAcesso.CADASTRA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.REMOVE_SERVIDOR);
			addPermissao(PermissaoDeAcesso.EDITA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.CADASTRA_UNIDADE_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.PESQUISA_UNIDADES_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.REMOVE_UNIDADES_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.EDITA_UNIDADES_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.CADASTRA_EVENTO);
			addPermissao(PermissaoDeAcesso.PESQUISA_EVENTO);
			addPermissao(PermissaoDeAcesso.REMOVE_EVENTO);
			addPermissao(PermissaoDeAcesso.EDITA_EVENTO);
			addPermissao(PermissaoDeAcesso.CADASTRA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.PESQUISA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.REMOVE_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.EDITA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.PESQUISA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.CADASTRA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.PESQUISA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.REMOVE_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.EDITA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.PESQUISA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.PESQUISA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.CADASTRA_LOGIN);
			addPermissao(PermissaoDeAcesso.PESQUISA_LOGIN);
			addPermissao(PermissaoDeAcesso.REMOVE_LOGIN);
			addPermissao(PermissaoDeAcesso.EDITA_LOGIN);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERIE_TURMA);
			break;
		
		case 3:
			addPermissao(PermissaoDeAcesso.PESQUISA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.PESQUISA_UNIDADES_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.PESQUISA_EVENTO);
			addPermissao(PermissaoDeAcesso.PESQUISA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.PESQUISA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.PESQUISA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.PESQUISA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.EDITA_LOGIN);
			break;
			
		case 4:
			addPermissao(PermissaoDeAcesso.PESQUISA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.CADASTRA_EVENTO);
			addPermissao(PermissaoDeAcesso.PESQUISA_EVENTO);
			addPermissao(PermissaoDeAcesso.REMOVE_EVENTO);
			addPermissao(PermissaoDeAcesso.EDITA_EVENTO);
			addPermissao(PermissaoDeAcesso.CADASTRA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.PESQUISA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.REMOVE_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.EDITA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.PESQUISA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.PESQUISA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.PESQUISA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.CADASTRA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.REMOVE_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.EDITA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.EDITA_LOGIN);
			break;
			
		case 5:
			addPermissao(PermissaoDeAcesso.PESQUISA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.CADASTRA_EVENTO);
			addPermissao(PermissaoDeAcesso.PESQUISA_EVENTO);
			addPermissao(PermissaoDeAcesso.REMOVE_EVENTO);
			addPermissao(PermissaoDeAcesso.EDITA_EVENTO);
			addPermissao(PermissaoDeAcesso.PESQUISA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.PESQUISA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.PESQUISA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.CADASTRA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.REMOVE_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.EDITA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.EDITA_LOGIN);
			break;
			
		case 6:
			addPermissao(PermissaoDeAcesso.PESQUISA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERVIDOR);
			addPermissao(PermissaoDeAcesso.CADASTRA_EVENTO);
			addPermissao(PermissaoDeAcesso.PESQUISA_EVENTO);
			addPermissao(PermissaoDeAcesso.REMOVE_EVENTO);
			addPermissao(PermissaoDeAcesso.EDITA_EVENTO);
			addPermissao(PermissaoDeAcesso.CADASTRA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.PESQUISA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.EDITA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.PESQUISA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.PESQUISA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.EDITA_LOGIN);
			break;
			
		case 7:
			addPermissao(PermissaoDeAcesso.CADASTRA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.PESQUISA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.REMOVE_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.EDITA_FORMACAO_EDUCACIONAL);
			addPermissao(PermissaoDeAcesso.PESQUISA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.CADASTRA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.PESQUISA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.REMOVE_AVALIACAO);
			addPermissao(PermissaoDeAcesso.EDITA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.CADASTRA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.PESQUISA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.REMOVE_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.EDITA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.PESQUISA_SERIE_TURMA);
			addPermissao(PermissaoDeAcesso.EDITA_LOGIN);
			break;
			
		case 8:

			addPermissao(PermissaoDeAcesso.PESQUISA_AVALIACAO);
			addPermissao(PermissaoDeAcesso.PESQUISA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.EDITA_ESTUDANTE);
			addPermissao(PermissaoDeAcesso.PESQUISA_EVENTO);
			addPermissao(PermissaoDeAcesso.PESQUISA_DISCIPLINA);
			addPermissao(PermissaoDeAcesso.PESQUISA_CONCEITO_NOTA);
			addPermissao(PermissaoDeAcesso.EDITA_LOGIN);
			break;
			
		default:
			break;
		}
	
		
	}
		
	@NonNull
	public StatusLogin getStatusLogin() {
		return StatusLogin.toEnum(statusLogin);
	}

	@NonNull
	public void setStatusLogin(StatusLogin statusLogin) {
		this.statusLogin = statusLogin.getCodigo();
	}

	@NonNull
	public Set<PermissaoDeAcesso> getPermissaoDeAcesso() {
		return permissoes.stream().map(x -> PermissaoDeAcesso.toEnum(x)).collect(Collectors.toSet());
	}

	@NonNull
	public void addPermissao(PermissaoDeAcesso permissaoDeAcesso) {
		
		permissoes.add(permissaoDeAcesso.getCodigo());
		
	}
	
	@NonNull
	public NivelDeAcesso getNivelDeAcesso() {
		
		return NivelDeAcesso.toEnum(nivelDeAcesso);
		
	}

	@NonNull
	public void setNivelDeAcesso(NivelDeAcesso nivelDeAcesso) {
		
		this.nivelDeAcesso = nivelDeAcesso.getCodigo();

	}

}