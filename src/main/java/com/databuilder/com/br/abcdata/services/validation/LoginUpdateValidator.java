package com.databuilder.com.br.abcdata.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.databuilder.com.br.abcdata.controller.exceptions.FieldMessage;
import com.databuilder.com.br.abcdata.dto.LoginDTO;
import com.databuilder.com.br.abcdata.entity.Login;
import com.databuilder.com.br.abcdata.repositories.LoginRepository;

public class LoginUpdateValidator implements ConstraintValidator<LoginUpdate, LoginDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private LoginRepository reposit;
	
	@Override
	public void initialize(LoginUpdate ann) {
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean isValid(LoginDTO objDto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getStatusLogin() == null) {
			list.add(new FieldMessage("statusUsuario", "Status não pode ser nulo"));
		}
		
		Optional<Login> aux = reposit.findByEmail(objDto.getEmail());
		if (aux != null && !aux.get().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente!!"));
		}
		
		// inclua os testes aqui, inserindo erros na lista
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}