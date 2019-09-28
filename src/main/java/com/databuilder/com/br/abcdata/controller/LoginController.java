package com.databuilder.com.br.abcdata.controller;

import static com.databuilder.com.br.abcdata.utils.ConstantesPaths.LOGINS;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.databuilder.com.br.abcdata.dto.LoginDTO;
import com.databuilder.com.br.abcdata.dto.LoginNewDTO;
import com.databuilder.com.br.abcdata.entity.Login;
import com.databuilder.com.br.abcdata.services.LoginService;
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
@Api(value = LOGINS, produces = MediaType.APPLICATION_JSON_VALUE, tags = {ConstantesTags.TAG_LOGIN})
@RequestMapping(value = LOGINS, produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginController {

	@Autowired
	private LoginService service;

	// Associado ao verbo HTTP
	@ApiOperation(value = "Busca Login por id", notes = "Endpoint para CONSULTAR Login por ID.", response = Login.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_LOGIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Login> find(@PathVariable Integer id) throws ObjectNotFoundException {

		Login obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

	// Associado ao verbo HTTP
	@ApiOperation(value = "Busca Login por Email", notes = "Endpoint para CONSULTAR Login por Email.", response = Login.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_LOGIN')")
	@RequestMapping(value = "/email", method = RequestMethod.GET)
	public ResponseEntity<Login> find(@RequestParam(value = "value") String email) {

		Login obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);

	}

	// Método para chamar Servico de inserir objeto
	@ApiOperation(value = "Insere Login", notes = "Endpoint para INSERIR Login.", response = URI.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_CADASTRA_LOGIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody LoginNewDTO objDto) {
		Login obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value = "Atualiza Login", notes = "Endpoint para ATUALIZAR Login.", response = ResponseEntity.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITA_LOGIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LoginDTO objDto, @PathVariable Integer id) {

		Login obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}

	// Associado ao verbo HTTP
	@ApiOperation(value = "Remove Login", notes = "Endpoint para REMOVER Login por Id.", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir um Login que tem Servidor criado"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REMOVE_LOGIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value = "Retorna todos os Logins", notes = "Endpoint para CONSULTAR todos os Login.", response = LoginDTO.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_LOGIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LoginDTO>> findAll() {

		List<Login> list = service.findAll();
		List<LoginDTO> listDto = list.stream().map(obj -> new LoginDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);

	}

	@ApiOperation(value = "Retorna Proprietarios até 24 linhas por pagina", notes = "Endpoint para CONSULTAR Login paginado.", response = LoginDTO.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_LOGIN')")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<LoginDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy) {

		Page<Login> list = service.findPage(page, linesPerPage, direction, orderBy);
		Page<LoginDTO> listDto = list.map(obj -> new LoginDTO(obj));
		return ResponseEntity.ok().body(listDto);

	}

}
