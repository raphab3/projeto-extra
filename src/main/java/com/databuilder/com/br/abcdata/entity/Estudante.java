package com.databuilder.com.br.abcdata.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.databuilder.com.br.abcdata.entity.enums.SituacaoEstudante;
import com.databuilder.com.br.abcdata.entity.enums.TipoEtnia;
import com.databuilder.com.br.abcdata.entity.enums.TipoGenero;

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
	@Column(unique = true)
	private Integer matriculaEstudante;
	private String nome;
	private Integer genero; // Campo ENUM
	private Integer etnia; // Campo ENUM
	private String nacionalidade;
	private Integer situacaoEstudante; // ENUM

	public Estudante(Integer id, Integer matriculaEstudante, String nome, TipoGenero genero, TipoEtnia etnia,
			String nacionalidade, SituacaoEstudante situacaoEstudante) {
		super();
		this.id = id;
		this.matriculaEstudante = matriculaEstudante;
		this.nome = nome;
		this.genero = genero.getCodigo();
		this.etnia = etnia.getCodigo();
		this.nacionalidade = nacionalidade;
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
	public SituacaoEstudante getSituacaoEstudante() {
		return SituacaoEstudante.toEnum(situacaoEstudante);
	}

	@NonNull
	public void setSituacaoEstudante(SituacaoEstudante situacaoEstudante) {
		this.situacaoEstudante = situacaoEstudante.getCodigo();
	}

}
