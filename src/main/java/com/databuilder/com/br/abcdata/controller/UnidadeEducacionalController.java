package com.databuilder.com.br.abcdata.controller;

import static com.databuilder.com.br.abcdata.utils.ConstantesPaths.UNIDADES_EDUCACIONAIS;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.databuilder.com.br.abcdata.entity.UnidadeEducacional;
import com.databuilder.com.br.abcdata.services.UnidadeEducacionalService;
import com.databuilder.com.br.abcdata.utils.ConstantesTags;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com
 * Data: 14/09/2018
 */

// Incluir anotations para compor a camada End-Poin REST
@RestController
@Api(value = UNIDADES_EDUCACIONAIS, produces = MediaType.APPLICATION_JSON_VALUE, tags = {ConstantesTags.TAG_UNIDADE_EDUCACIONAL})
@RequestMapping(value = UNIDADES_EDUCACIONAIS, produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadeEducacionalController {

	@Autowired
	private UnidadeEducacionalService service;

	// Associado ao verbo HTTP
	@ApiOperation(value = "Busca UnidadeEducacional por id", notes = "Endpoint para CONSULTAR Unidade Educacional por ID.", response = UnidadeEducacional.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_UNIDADE_EDUCACIONAL')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UnidadeEducacional> find(@PathVariable Integer id) {

		UnidadeEducacional obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}

	// Método para chamar Servico de inserir objeto
	@ApiOperation(value = "Insere UnidadeEducacional", notes = "Endpoint para INSERIR Unidade Educacional.", response = URI.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_CADASTRA_UNIDADE_EDUCACIONAL')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UnidadeEducacional obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value="Atualiza UnidadeEducacional", notes = "Endpoint para ALTERAR Unidade Educacional.", response = ResponseEntity.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITA_UNIDADE_EDUCACIONAL')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UnidadeEducacional obj, @PathVariable Integer id) {

		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}

	// Associado ao verbo HTTP
	@ApiOperation(value="Remove UnidadeEducacional", notes = "Endpoint para REMOVER Unidade Educacional.", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir um UnidadeEducacional que está em vários Nucleos"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REMOVE_UNIDADE_EDUCACIONAL')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value="Consulta todas as Unidades Educacionais", notes = "Endpoint para CONSULTAR todas as Unidades Educacionais.", response = UnidadeEducacional.class)
	@PreAuthorize("hasAnyRole('ADMIN', 'ROLE_PESQUISA_UNIDADE_EDUCACIONAL')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UnidadeEducacional>> findAll() {

		List<UnidadeEducacional> list = service.findAll();

		return ResponseEntity.ok().body(list);

	}

}
