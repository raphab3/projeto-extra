package com.databuilder.com.br.abcdata.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.databuilder.com.br.abcdata.entity.Disciplina;
import com.databuilder.com.br.abcdata.repositories.DisciplinaRepository;
import com.databuilder.com.br.abcdata.security.UserSS;
import com.databuilder.com.br.abcdata.services.exceptions.AuthorizationException;
import com.databuilder.com.br.abcdata.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.abcdata.services.exceptions.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository reposit;
	
	public Disciplina find(Integer id) {

		UserSS user = UserService.authenticated();

		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}

		//Login usuario = usuarioService.find(user.getId());

		Optional<Disciplina> obj = reposit.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));

	}

	@Transactional
	public Disciplina insert(Disciplina obj) {

		obj.setId(null); // faz o método entender que se não houver ID então é uma alteração
		return reposit.save(obj);

	}

	public Disciplina update(Disciplina obj) {

		Disciplina newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public void delete(Integer id) {

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir uma Disciplina");
		}
	}

	public List<Disciplina> findAll() {
		return reposit.findAll();
	}

	public Page<Disciplina> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return reposit.findAll(pageRequest);
	}

	private void updateData(Disciplina newObj, Disciplina obj) {
		newObj.setId(obj.getId());
		newObj.setDisciplina(obj.getDisciplina());
		newObj.setCargaHoraria(obj.getCargaHoraria());		
	}

}
