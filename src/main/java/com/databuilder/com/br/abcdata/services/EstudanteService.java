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

import com.databuilder.com.br.abcdata.dto.EstudanteDTO;
import com.databuilder.com.br.abcdata.entity.Estudante;
import com.databuilder.com.br.abcdata.repositories.EstudanteRepository;
import com.databuilder.com.br.abcdata.security.UserSS;
import com.databuilder.com.br.abcdata.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.abcdata.services.exceptions.ObjectNotFoundException;
import com.databuilder.com.br.abcdata.services.validation.RegraDePermissao;

@Service
public class EstudanteService {

	@Autowired
	private EstudanteRepository reposit;

	public Estudante find(Integer id) {

		RegraDePermissao.acessaRegrasPorId(id);

		Optional<Estudante> obj = reposit.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estudante.class.getName()));

	}

	@Transactional
	public Estudante insert(Estudante obj) {

		obj.setId(null);
		return reposit.save(obj);

	}

	public Estudante update(Estudante obj) {

		RegraDePermissao.acessaRegrasPorId(obj.getId());

		Estudante newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public void delete(Integer id) {

		RegraDePermissao.acessaRegrasPorId(id);

		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um Estudante");
		}
	}

	public List<Estudante> findAlunoEscola(String unidadeeducacionalid) {

		UserSS user = UserService.authenticated();
		int liberado = 0;
		RegraDePermissao regra = new RegraDePermissao();
		regra.acessaRegrasGeral(liberado);
		Integer servidor = user.getId();

		return reposit.findAlunoEscola(servidor, unidadeeducacionalid);

	}

	public Page<Estudante> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {

//		RegraDePermissao.acessaRegrasGeral();

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return reposit.findAll(pageRequest);
	}

	public Estudante fromDTO(EstudanteDTO objDto) {

		return new Estudante(objDto.getId(), objDto.getDataCadastro(), objDto.getDataUltimaAlteracao(),
				objDto.getMatriculaEstudante(), objDto.getNome(), objDto.getDataNascimento(), objDto.getGenero(),
				objDto.getEtnia(), objDto.getNacionalidade(), null, objDto.getFiliacaoMae(), objDto.getFiliacaoPai(),
				objDto.getResponsavelEstudante(), objDto.getEmailResponsavel(), objDto.getTelefoneResponsavel(),
				objDto.getCertidaoNascimento(), objDto.getTransferenciaOutraEscola(), objDto.getFotografia(),
				objDto.getSituacaoEstudante()
//				, objDto.getSerieTurma()
		);

	}

	private void updateData(Estudante newObj, Estudante obj) {
		newObj.setDataCadastro(obj.getDataCadastro());
		newObj.setDataUltimaAlteracao(obj.getDataUltimaAlteracao());
		newObj.setMatriculaEstudante(obj.getMatriculaEstudante());
		newObj.setNome(obj.getNome());
		newObj.setDataNascimento(obj.getDataNascimento());
		newObj.setTipoGenero(obj.getGenero());
		newObj.setTipoEtnia(obj.getEtnia());
		newObj.setNacionalidade(obj.getNacionalidade());
		newObj.setLogin(obj.getLogin());
		newObj.setFiliacaoMae(obj.getFiliacaoMae());
		newObj.setFiliacaoPai(obj.getFiliacaoPai());
		newObj.setResponsavelEstudante(obj.getResponsavelEstudante());
		newObj.setEmailResponsavel(obj.getEmailResponsavel());
		newObj.setTelefoneResponsavel(obj.getTelefoneResponsavel());
		newObj.setSituacaoEntrega(obj.getCertidaoNascimento());
		newObj.setSituacaoEntrega1(obj.getTransferenciaOutraEscola());
		newObj.setSituacaoEntrega2(obj.getFotografia());
		newObj.setSituacaoEstudante(obj.getSituacaoEstudante());
	}

}
