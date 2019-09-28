package com.databuilder.com.br.abcdata.controller;

import static com.databuilder.com.br.abcdata.utils.ConstantesPaths.SERVIDORES;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.databuilder.com.br.abcdata.dto.ServidorDTO;
import com.databuilder.com.br.abcdata.entity.Servidor;
import com.databuilder.com.br.abcdata.services.ServidorService;
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
@Api(value = SERVIDORES, produces = MediaType.APPLICATION_JSON_VALUE, tags = {ConstantesTags.TAG_SERVIDOR})
@RequestMapping(value = SERVIDORES, produces = MediaType.APPLICATION_JSON_VALUE)
public class ServidorController {

	@Autowired
	private ServidorService service;

	// Associado ao verbo HTTP
	@ApiOperation(value="Busca Servidor por id", notes = "Endpoint para CONSULTAR Servidor por ID.", response = Servidor.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_SERVIDOR')")
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Servidor> find(@PathVariable Integer id) throws ObjectNotFoundException {

		//TODO: Criar uso de acesso proprio
		
		Servidor obj = service.find(id);

		return ResponseEntity.ok().body(obj);

	}

	// Método para chamar Servico de inserir objeto
	@ApiOperation(value="Insere nova Servidor", notes = "Endpoint para INSERIR Servidor.", response = URI.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_CADASTRA_SERVIDOR')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Servidor obj) {

		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}

	@ApiOperation(value="Atualiza Servidor", notes = "Endpoint para ATUALIZAR Servidor.", response = ResponseEntity.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_EDITA_SERVIDOR')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Servidor obj, @PathVariable Integer id) {

		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}

	// Associado ao verbo HTTP
	@ApiOperation(value="Remove Servidor", notes = "Endpoint para REMOVER Servidor por ID.", response = ResponseEntity.class)
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir uma Servidor que possui membros"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_REMOVE_SERVIDOR')")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {

		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	@ApiOperation(value="Consulta todos os Servidores", notes = "Endpoint para CONSULTAR todos os Servidores.", response = ServidorDTO.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_SERVIDOR')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ServidorDTO>> findAll() {

		List<Servidor> list = service.findAll();
		List<ServidorDTO> listDto = list.stream().map(obj -> new ServidorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);

	}

	@ApiOperation(value="Retorna Servidores até 24 linhas por pagina", notes = "Endpoint para CONSULTAR Servidores paginado.", response = Servidor.class)
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_PESQUISA_SERVIDOR')")
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ResponseEntity<Page<Servidor>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="direction", defaultValue="DESC") String direction, 
			@RequestParam(value="orderBy", defaultValue="id") String orderBy) {
		Page<Servidor> list = service.findPage(page, linesPerPage, direction, orderBy);
		return ResponseEntity.ok().body(list);

	}
	
	// Método para chamar Servico de inserir objeto
	@ApiOperation(value="Insere Imagem do Profile")
	@PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_CADASTRA_SERVIDOR')")
	@RequestMapping(value="/picture", method=RequestMethod.POST)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file) {

		URI uri = service.uploadProfilePicture(file);
		return ResponseEntity.created(uri).build();
		
	}
	
}
