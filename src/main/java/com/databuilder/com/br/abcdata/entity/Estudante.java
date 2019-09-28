package com.databuilder.com.br.abcdata.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.databuilder.com.br.abcdata.entity.enums.SituacaoEntrega;
import com.databuilder.com.br.abcdata.entity.enums.SituacaoEstudante;
import com.databuilder.com.br.abcdata.entity.enums.TipoEtnia;
import com.databuilder.com.br.abcdata.entity.enums.TipoGenero;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@Entity
@Table(name = "estudante")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Estudante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataCadastro;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataUltimaAlteracao;
	@Column(unique = true)
	private Integer matriculaEstudante;
	private String nome;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	private Integer genero; // Campo ENUM
	private Integer etnia; // Campo ENUM
	private String nacionalidade;
	@OneToOne
	@JoinColumn(name = "login_id")
	private Login login;
	private String filiacaoMae;
	private String filiacaoPai;
	private String responsavelEstudante;
	private String emailResponsavel;
	private String telefoneResponsavel;
	private Integer certidaoNascimento; // ENUM
	private Integer transferenciaOutraEscola; // ENUM
	private Integer fotografia; // ENUM
	private Integer situacaoEstudante; // ENUM

	public Estudante(Integer id, Date dataCadastro, Date dataUltimaAlteracao, Integer matriculaEstudante, String nome,
			Date dataNascimento, TipoGenero genero, TipoEtnia etnia, String nacionalidade, Login login,
			String filiacaoMae, String filiacaoPai, String responsavelEstudante, String emailResponsavel,
			String telefoneResponsavel, SituacaoEntrega certidaoNascimento, SituacaoEntrega transferenciaOutraEscola,
			SituacaoEntrega fotografia, SituacaoEstudante situacaoEstudante) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.matriculaEstudante = matriculaEstudante;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.genero = genero.getCodigo();
		this.etnia = etnia.getCodigo();
		this.nacionalidade = nacionalidade;
		this.login = login;
		this.filiacaoMae = filiacaoMae;
		this.filiacaoPai = filiacaoPai;
		this.responsavelEstudante = responsavelEstudante;
		this.emailResponsavel = emailResponsavel;
		this.telefoneResponsavel = telefoneResponsavel;
		this.certidaoNascimento = certidaoNascimento.getCodigo();
		this.transferenciaOutraEscola = transferenciaOutraEscola.getCodigo();
		this.fotografia = fotografia.getCodigo();
		this.situacaoEstudante = situacaoEstudante.getCodigo();
	}

	@NonNull
	public TipoGenero getGenero() {
		return TipoGenero.toEnum(genero);
	}

	@NonNull
	public void setTipoGenero(TipoGenero genero) {
		this.genero = genero.getCodigo();
	}

	@NonNull
	public TipoEtnia getEtnia() {
		return TipoEtnia.toEnum(etnia);
	}

	@NonNull
	public void setTipoEtnia(TipoEtnia etnia) {
		this.etnia = etnia.getCodigo();
	}

	@NonNull
	public SituacaoEntrega getCertidaoNascimento() {
		return SituacaoEntrega.toEnum(certidaoNascimento);
	}

	@NonNull
	public void setSituacaoEntrega(SituacaoEntrega certidaoNascimento) {
		this.certidaoNascimento = certidaoNascimento.getCodigo();
	}

	@NonNull
	public SituacaoEntrega getTransferenciaOutraEscola() {
		return SituacaoEntrega.toEnum(transferenciaOutraEscola);
	}

	@NonNull
	public void setSituacaoEntrega1(SituacaoEntrega transferenciaOutraEscola) {
		this.transferenciaOutraEscola = transferenciaOutraEscola.getCodigo();
	}

	@NonNull
	public SituacaoEntrega getFotografia() {
		return SituacaoEntrega.toEnum(fotografia);
	}

	@NonNull
	public void setSituacaoEntrega2(SituacaoEntrega fotografia) {
		this.fotografia = fotografia.getCodigo();
	}

	@NonNull
	public SituacaoEstudante getSituacaoEstudante() {
		return SituacaoEstudante.toEnum(situacaoEstudante);
	}

	@NonNull
	public void setSituacaoEstudante(SituacaoEstudante situacaoEstudante) {
		this.situacaoEstudante = situacaoEstudante.getCodigo();
	}

}
