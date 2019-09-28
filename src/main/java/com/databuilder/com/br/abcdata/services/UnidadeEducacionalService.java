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

import com.databuilder.com.br.abcdata.entity.UnidadeEducacional;
import com.databuilder.com.br.abcdata.repositories.UnidadeEducacionalRepository;
import com.databuilder.com.br.abcdata.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.abcdata.services.exceptions.ObjectNotFoundException;

@Service
public class UnidadeEducacionalService {

	@Autowired
	private UnidadeEducacionalRepository reposit;

	public UnidadeEducacional find(Integer id) throws ObjectNotFoundException {

		Optional<UnidadeEducacional> obj = reposit.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + UnidadeEducacional.class.getName()));

	}

	@Transactional
	public UnidadeEducacional insert(UnidadeEducacional obj) {

		UnidadeEducacional newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public UnidadeEducacional update(UnidadeEducacional obj) {

		UnidadeEducacional newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public void delete(Integer id) {

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um UnidadeEducacional");
		}
	}

	public List<UnidadeEducacional> findAll() {
		return reposit.findAll();
	}

	public Page<UnidadeEducacional> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return reposit.findAll(pageRequest);
	}

	private void updateData(UnidadeEducacional newObj, UnidadeEducacional obj) {

		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setCodigoInep(obj.getCodigoInep());
		newObj.setUnidadeEducacional(obj.getUnidadeEducacional());
		newObj.setDependenciaAcessibilidade(obj.getDependenciaAcessibilidade());
		newObj.setSanitariosComAcessibilidade(obj.getSanitariosComAcessibilidade());
		newObj.setSanitarioDentroPredio(obj.getSanitarioDentroPredio());
		newObj.setSanitarioForaPredio(obj.getSanitarioForaPredio());
		newObj.setBiblioteca(obj.getBiblioteca());
		newObj.setCozinha(obj.getCozinha());
		newObj.setLaboratorioDeInformatica(obj.getLaboratorioDeInformatica());
		newObj.setLaboratorioDeCiencias(obj.getLaboratorioDeCiencias());
		newObj.setLaboratorioDeRobotica(obj.getLaboratorioDeRobotica());
		newObj.setSalaDeLeitura(obj.getSalaDeLeitura());
		newObj.setQuadraEsportiva(obj.getQuadraEsportiva());
		newObj.setSalaDiretoria(obj.getSalaDiretoria());
		newObj.setSalaProfessores(obj.getSalaProfessores());
		newObj.setSalaAtendimentoEspecial(obj.getSalaAtendimentoEspecial());
		newObj.setPlayground(obj.getPlayground());
		newObj.setCampoDeFutebol(obj.getCampoDeFutebol());
		newObj.setRefeitorio(obj.getRefeitorio());
		
	}

}
