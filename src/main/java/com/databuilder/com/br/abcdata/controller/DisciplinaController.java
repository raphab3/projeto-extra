package com.databuilder.com.br.abcdata.controller;

import static com.databuilder.com.br.abcdata.utils.ConstantesPaths.DISCIPLINAS;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.databuilder.com.br.abcdata.dto.DisciplinaDTO;
import com.databuilder.com.br.abcdata.entity.Disciplina;
import com.databuilder.com.br.abcdata.services.DisciplinaService;
import com.databuilder.com.br.abcdata.utils.ConstantesTags;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.tools.rmi.ObjectNotFoundException;

/**
 * Created by Wendell Clive Santos de Lira - Email: wendell.clive@gmail.com
 * Data: 14/09/2018
 */

// Incluir anotations para compor a camada End-Poin REST
@RestController
@Api(value = DISCIPLINAS, produces = MediaType.APPLICATION_JSON_VALUE, tags = {ConstantesTags.TAG_DISCIPLINA})
@RequestMapping(value = DISCIPLINAS, produces = MediaType.APPLICATION_JSON_VALUE)
public class DisciplinaController {

	@Autowired
	private DisciplinaService service;

	// Associado ao verbo HTTP
	@ApiOperation(value = "Busca Disciplina por id", notes = "Endpoint para CONSULTAR Disciplina por ID.", response = Disciplina.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_DISCIPLINA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Disciplina> find(@PathVariable Integer id) throws ObjectNotFoundException {

		Disciplina obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}

	// Método para chamar Servico de inserir objeto
	@ApiOperation(value = "Insere nova Disciplina", notes = "Endpoint para INSERE nova Disciplina.", response = URI.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_CADASTRA_DISCIPLINA')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Disciplina obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Atualiza Disciplina", notes = "Endpoint para ATUALIZAR Disciplina por ID.", response = ResponseEntity.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITA_DISCIPLINA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Disciplina obj, @PathVariable Integer id) {

		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}

	// Associado ao verbo HTTP
	@ApiOperation(value = "Remove Disciplina", notes = "Endpoint para REMOVER Disciplina por ID.", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Não é possível excluir um Disciplina que possui dados"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REMOVE_DISCIPLINA')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value = "Retorna todas as disciplinas", notes = "Endpoint para CONSULTAR todas as Disciplinas.", response = DisciplinaDTO.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_DISCIPLINA')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DisciplinaDTO>> findAll() {

		List<Disciplina> list = service.findAll();
		List<DisciplinaDTO> listDto = list.stream().map(obj -> new DisciplinaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

}
