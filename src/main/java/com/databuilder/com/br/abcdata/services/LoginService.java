package com.databuilder.com.br.abcdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.databuilder.com.br.abcdata.dto.LoginDTO;
import com.databuilder.com.br.abcdata.dto.LoginNewDTO;
import com.databuilder.com.br.abcdata.entity.Login;
import com.databuilder.com.br.abcdata.entity.enums.NivelDeAcesso;
import com.databuilder.com.br.abcdata.entity.enums.PermissaoDeAcesso;
import com.databuilder.com.br.abcdata.entity.enums.StatusLogin;
import com.databuilder.com.br.abcdata.repositories.LoginRepository;
import com.databuilder.com.br.abcdata.security.UserSS;
import com.databuilder.com.br.abcdata.services.exceptions.AuthorizationException;
import com.databuilder.com.br.abcdata.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.abcdata.services.exceptions.ObjectNotFoundException;

@Service
public class LoginService {

	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private LoginRepository reposit;
	
	public Login find(Integer id) throws ObjectNotFoundException {
		
		UserSS user = UserService.authenticated();
		
		if (user==null || !user.hasHole(PermissaoDeAcesso.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<Login> obj = reposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Login.class.getName()));
		
	}
	
	@Transactional
	public Login insert(Login obj) {

		obj.setId(null); // faz o método entender que se não houver ID então é uma alteração
		return reposit.save(obj);

	}

	public Login update(Login obj) {

		Login newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public void delete(Integer id) {

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um Login");
		}
	}
	
	public List<Login> findAll() {
		
		UserSS user = UserService.authenticated();
		
		if (user==null || !user.hasHole(PermissaoDeAcesso.ADMIN)) {
			throw new AuthorizationException("Acesso negado");
		}
		
		return reposit.findAll();
	}
	
	public Login findByEmail(String email) {
		
		UserSS user = UserService.authenticated();
		if (user==null || !user.hasHole(PermissaoDeAcesso.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}

		Optional<Login> obj = reposit.findByEmail(email);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + email + ", Tipo: " + Login.class.getName()));
		
	}
	
	public Page<Login> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return reposit.findAll(pageRequest);
	}
	
	public Login fromDTO(LoginDTO objDto) {
		return new Login(
				objDto.getId(), 
				objDto.getNome(), 
				objDto.getEmail(), null, 
				objDto.getDataCadastro(), 
				objDto.getStatusLogin(), 
				objDto.getTentativasDeAcesso(),
				objDto.getNivelDeAcesso());
	}

	public Login fromDTO(LoginNewDTO objDto) {
		Login prop = new Login(
				null, 
				objDto.getEmail(), 
				objDto.getNome(), 
				pe.encode(objDto.getSenha()), 
				objDto.getDataCadastro(), 
				StatusLogin.toEnum(objDto.getStatusUsuario()), 
				objDto.getTentativasDeAcesso(), 
				NivelDeAcesso.toEnum(objDto.getNivelDeAcesso()));
		return prop;
		
	}

	private void updateData(Login newObj, Login obj) {
		newObj.setNomeUsuario(obj.getNomeUsuario());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setStatusLogin(obj.getStatusLogin());
		newObj.setTentativasDeAcesso(obj.getTentativasDeAcesso());
	}
	
}
