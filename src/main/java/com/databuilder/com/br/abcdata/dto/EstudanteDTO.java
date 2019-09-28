package com.databuilder.com.br.abcdata.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.databuilder.com.br.abcdata.entity.Estudante;
import com.databuilder.com.br.abcdata.entity.enums.SituacaoEntrega;
import com.databuilder.com.br.abcdata.entity.enums.SituacaoEstudante;
import com.databuilder.com.br.abcdata.entity.enums.TipoEtnia;
import com.databuilder.com.br.abcdata.entity.enums.TipoGenero;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataCadastro;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataUltimaAlteracao;
	@Column(unique = true)
	private Integer matriculaEstudante;
	private String nome;
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dataNascimento;
	private TipoGenero genero; 
	private TipoEtnia etnia; 
	private String nacionalidade;
	private String filiacaoMae;
	private String filiacaoPai;
	private String responsavelEstudante;
	private String emailResponsavel;
	private String telefoneResponsavel;
	private SituacaoEntrega certidaoNascimento;
	private SituacaoEntrega transferenciaOutraEscola;  
	private SituacaoEntrega fotografia;
	private SituacaoEstudante situacaoEstudante;
//	private SerieTurma serieTurma;
	
	public EstudanteDTO(Estudante obj) {

		id = obj.getId();
		dataCadastro = obj.getDataCadastro();
		dataUltimaAlteracao = obj.getDataUltimaAlteracao();
		matriculaEstudante = obj.getMatriculaEstudante();
		nome = obj.getNome();
		dataNascimento = obj.getDataNascimento();
		genero = obj.getGenero();
		etnia = obj.getEtnia();
		nacionalidade = obj.getNacionalidade();
		filiacaoMae = obj.getFiliacaoMae();
		filiacaoPai = obj.getFiliacaoPai();
		responsavelEstudante = obj.getResponsavelEstudante();
		emailResponsavel = obj.getEmailResponsavel();
		telefoneResponsavel = obj.getTelefoneResponsavel();		
		certidaoNascimento = obj.getCertidaoNascimento();
		transferenciaOutraEscola = obj.getTransferenciaOutraEscola();
		fotografia = obj.getFotografia();
		situacaoEstudante = obj.getSituacaoEstudante();
	//	serieTurma = obj.getSerieTurma();
	}
}
