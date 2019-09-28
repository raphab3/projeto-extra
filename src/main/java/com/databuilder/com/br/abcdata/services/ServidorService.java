package com.databuilder.com.br.abcdata.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.databuilder.com.br.abcdata.dto.ServidorDTO;
import com.databuilder.com.br.abcdata.entity.Servidor;
import com.databuilder.com.br.abcdata.repositories.ServidorRepository;
import com.databuilder.com.br.abcdata.security.UserSS;
import com.databuilder.com.br.abcdata.services.exceptions.AuthorizationException;
import com.databuilder.com.br.abcdata.services.exceptions.DataIntegrityException;
import com.databuilder.com.br.abcdata.services.exceptions.ObjectNotFoundException;
import com.databuilder.com.br.abcdata.services.validation.RegraDePermissao;

@Service
public class ServidorService {

	@Autowired
	private ServidorRepository reposit;

	@Autowired
	private ImageService imageService;
	
	@Autowired
	private S3Service s3Service;

	@Value("${img.prefix.client.profile}")
	private String prefix;

	@Value("${img.profile.size}")
	private Integer size;
	
	public Servidor find(Integer id) {

		RegraDePermissao.acessaRegrasPorId(id);
		
		Optional<Servidor> obj = reposit.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Servidor.class.getName()));

	}

	@Transactional
	public Servidor insert(Servidor obj) {

		obj.setId(null); // faz o método entender que se não houver ID então é uma alteração
		return reposit.save(obj);

	}

	public Servidor update(Servidor obj) {

		RegraDePermissao.acessaRegrasPorId(obj.getId());
		
		Servidor newObj = find(obj.getId());
		updateData(newObj, obj);
		return reposit.save(newObj);

	}

	public void delete(Integer id) {

		RegraDePermissao.acessaRegrasPorId(id);
		
		find(id);
		try {
			reposit.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel Excluir um Servidor");
		}
	}

	public List<Servidor> findAll() {
		
//		RegraDePermissao.acessaRegrasGeral();
		return reposit.findAll();
	}

	public Page<Servidor> findPage(Integer page, Integer linesPerPage, String direction, String orderBy) {

//		RegraDePermissao.acessaRegrasGeral();
		
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return reposit.findAll(pageRequest);
	}

	public Servidor fromDTO(ServidorDTO objDto) {
		
		return new Servidor();
	}
	
	
	private void updateData(Servidor newObj, Servidor obj) {
		newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf());
		newObj.setGenero(obj.getGenero());
		newObj.setEtnia(obj.getEtnia());
		newObj.setNacionalidade(obj.getNacionalidade());		
	}

	
	//Methodo para o proprio usuario incluir a sua imagem
	public URI uploadProfilePicture(MultipartFile multipartFile) {

		UserSS user = UserService.authenticated();
		
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);
		
		String fileName = prefix + user.getId() + ".jpg";
		
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
		
	}
	
	//Methodo para qualquer usuario incluir uma image de usuarios
	/*
	public URI uploadProfilePicture(MultipartFile multipartFile) {

		UserSS user = UserService.authenticated();
		
		if (user==null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);
		
		String fileName = prefix + user.getId() + ".jpg";
		
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
		
	}
	*/
}
