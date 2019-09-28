package com.databuilder.com.br.abcdata.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/***
 * 
 * Created by Wendell Clive - email: wendell.clive@gmail.com 14/09/2018
 */

@NoArgsConstructor
@Entity
@Table(name="unidade_educacional")
@Getter 
@Setter
@EqualsAndHashCode
public class UnidadeEducacional implements Serializable {

	private static final long serialVersionUID = 5914356445552675840L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date dataCadastro;
	private String codigoInep;
	private String unidadeEducacional;
	private Integer dependenciaAcessibilidade;	
	private Integer sanitariosComAcessibilidade;
	private Integer sanitarioDentroPredio;
	private Integer sanitarioForaPredio;
	private Integer biblioteca;
	private Integer cozinha;
	private Integer laboratorioDeInformatica;
	private Integer laboratorioDeCiencias;
	private Integer laboratorioDeRobotica;
	private Integer salaDeLeitura;
	private Integer quadraEsportiva;
	private Integer salaDiretoria;
	private Integer salaProfessores;
	private Integer salaAtendimentoEspecial;
	private Integer playground;
	private Integer campoDeFutebol;
	private Integer refeitorio;
	
	@ManyToMany
	@JoinTable(name = "ESCOLA_SERVIDOR", 
			   joinColumns = @JoinColumn(name = "unidadeeducacional_id"),
			   inverseJoinColumns = @JoinColumn(name = "servidores"))
	private List<Servidor> servidores = new ArrayList<>();
	
	public UnidadeEducacional(Integer id, Date dataCadastro, String codigoInep, String unidadeEducacional,
			Integer dependenciaAcessibilidade, Integer sanitariosComAcessibilidade,
			Integer sanitarioDentroPredio, Integer sanitarioForaPredio, Integer biblioteca, Integer cozinha,
			Integer laboratorioDeInformatica, Integer laboratorioDeCiencias, Integer laboratorioDeRobotica,
			Integer salaDeLeitura, Integer quadraEsportiva, Integer salaDiretoria, Integer salaProfessores,
			Integer salaAtendimentoEspecial, Integer playground, Integer campoDeFutebol, Integer refeitorio) {
		super();
		this.id = id;
		this.dataCadastro = dataCadastro;
		this.codigoInep = codigoInep;
		this.unidadeEducacional = unidadeEducacional;
		this.dependenciaAcessibilidade = dependenciaAcessibilidade;
		this.sanitariosComAcessibilidade = sanitariosComAcessibilidade;
		this.sanitarioDentroPredio = sanitarioDentroPredio;
		this.sanitarioForaPredio = sanitarioForaPredio;
		this.biblioteca = biblioteca;
		this.cozinha = cozinha;
		this.laboratorioDeInformatica = laboratorioDeInformatica;
		this.laboratorioDeCiencias = laboratorioDeCiencias;
		this.laboratorioDeRobotica = laboratorioDeRobotica;
		this.salaDeLeitura = salaDeLeitura;
		this.quadraEsportiva = quadraEsportiva;
		this.salaDiretoria = salaDiretoria;
		this.salaProfessores = salaProfessores;
		this.salaAtendimentoEspecial = salaAtendimentoEspecial;
		this.playground = playground;
		this.campoDeFutebol = campoDeFutebol;
		this.refeitorio = refeitorio;
	}

}
