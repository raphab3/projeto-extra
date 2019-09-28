package com.databuilder.com.br.abcdata.dto;

import java.io.Serializable;

import javax.persistence.Column;

import com.databuilder.com.br.abcdata.entity.Estudante;
import com.databuilder.com.br.abcdata.entity.enums.SituacaoEstudante;
import com.databuilder.com.br.abcdata.entity.enums.TipoEtnia;
import com.databuilder.com.br.abcdata.entity.enums.TipoGenero;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@NoArgsConstructor
@Getter
@Setter
public class EstudanteDTO implements Serializable {

	private static final long serialVersionUID = 5914356445552675840L;

	private Integer id;
	@Column(unique = true)
	private Integer matriculaEstudante;
	private String nome;
	private TipoGenero genero; 
	private TipoEtnia etnia; 
	private String nacionalidade;
	private SituacaoEstudante situacaoEstudante;
	
	public EstudanteDTO(Estudante obj) {

		id = obj.getId();
		matriculaEstudante = obj.getMatriculaEstudante();
		nome = obj.getNome();
		genero = obj.getGenero();
		etnia = obj.getEtnia();
		nacionalidade = obj.getNacionalidade();
		situacaoEstudante = obj.getSituacaoEstudante();
	}
}
