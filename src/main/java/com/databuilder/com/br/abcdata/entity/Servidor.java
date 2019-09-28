package com.databuilder.com.br.abcdata.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private Integer matricula;
	private String nome;
	private String cpf;	
	private Integer genero; // Campo ENUM
	private Integer etnia; // Campo ENUM
	private String nacionalidade;
	private Integer tipoServidor; // Campo ENUM

	@JsonIgnore
	@ManyToMany(mappedBy = "servidores")
	private List<UnidadeEducacional> unidadesEducacionais = new ArrayList<>();

	public Servidor(Integer id, Integer matricula, String nome,
			String cpf, TipoGenero genero, TipoEtnia etnia,
			String nacionalidade, TipoServidor tipoServidor) {

		this.id = id;
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.genero = genero.getCodigo();
		this.etnia = etnia.getCodigo();
		this.nacionalidade = nacionalidade;
		this.tipoServidor = tipoServidor.getCodigo();
	}

}
