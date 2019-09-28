package com.databuilder.com.br.abcdata.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.databuilder.com.br.abcdata.entity.enums.TipoEtnia;
import com.databuilder.com.br.abcdata.entity.enums.TipoGenero;
import com.databuilder.com.br.abcdata.entity.enums.TipoServidor;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@Entity
@Table(name = "servidor")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Servidor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataCadastro;
	private Date dataUltimaAlteracao;
	@Column(unique = true)
	private Integer matricula;
	private String nome;
	private String nomeSocial;
	@Column(unique = true)
	private String cpf;
	private Date dataNascimento;
	private Integer genero; // Campo ENUM
	private Integer etnia; // Campo ENUM
	private String nacionalidade;

	@OneToOne
	@JoinColumn(name = "login_id")
	private Login login;

	private Integer nis;
	private String filiacaoMae;
	private String filiacaoPai;
	private Integer tipoServidor; // Campo ENUM

	@JsonIgnore
	@ManyToMany(mappedBy = "servidores")
	private List<UnidadeEducacional> unidadesEducacionais = new ArrayList<>();

	public Servidor(Integer id, Date dataCadastro, Date dataUltimaAlteracao, Integer matricula, String nome,
			String nomeSocial, String cpf, Date dataNascimento, TipoGenero genero, TipoEtnia etnia,
			String nacionalidade, Login login, String filiacaoMae, String filiacaoPai, TipoServidor tipoServidor) {

		this.id = id;
		this.dataCadastro = dataCadastro;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.matricula = matricula;
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.genero = genero.getCodigo();
		this.etnia = etnia.getCodigo();
		this.nacionalidade = nacionalidade;
		this.login = login;
		this.filiacaoMae = filiacaoMae;
		this.filiacaoPai = filiacaoPai;
		this.tipoServidor = tipoServidor.getCodigo();
	}

}
