package com.databuilder.com.br.abcdata.controller;

import static com.databuilder.com.br.abcdata.utils.ConstantesPaths.ESTUDANTES;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

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

import com.databuilder.com.br.abcdata.dto.EstudanteDTO;
import com.databuilder.com.br.abcdata.entity.Estudante;
import com.databuilder.com.br.abcdata.services.EstudanteService;
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
@Api(value = ESTUDANTES, produces = MediaType.APPLICATION_JSON_VALUE, tags = {ConstantesTags.TAG_ESTUDANTE})
@RequestMapping(value = ESTUDANTES, produces = MediaType.APPLICATION_JSON_VALUE)
public class EstudanteController {

	@Autowired
	private EstudanteService service;
	
	// Associado ao verbo HTTP
	@ApiOperation(value="Busca Estudantes por id", notes = "Endpoint para CONSULTAR Estudante por ID.", response = Estudante.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_ESTUDANTE')")
	public ResponseEntity<Estudante> find(@PathVariable Integer id) {

		Estudante obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}

	// Método para chamar Servico de inserir objeto
	@ApiOperation(value="Insere Estudante", notes = "Endpoint para INSERIR Estudante.", response = URI.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_CADASTRA_ESTUDANTE')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EstudanteDTO objDto) {

		Estudante obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

	@ApiOperation(value="Atualiza Estudante", notes = "Endpoint para ATUALIZAR Estudante.", response = ResponseEntity.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITA_ESTUDANTE')")
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EstudanteDTO objDto, @PathVariable Integer id) {

		Estudante obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
		
	}
	
	// Associado ao verbo HTTP
	@ApiOperation(value="Remove Estudante", notes = "Endpoint para REMOVER Estudante.", response = ResponseEntity.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REMOVE_ESTUDANTE')")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir uma Estudante que possui membros"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	
	
	@ApiOperation(value="Retorna todos os Estudantes", notes = "Endpoint para CONSULTAR Todos os Estudante.", response = EstudanteDTO.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_ESTUDANTE')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EstudanteDTO>> findAll() {
		
		List<Estudante> list = service.findAll();
		List<EstudanteDTO> listDto = list.stream().map(obj -> new EstudanteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

		
}