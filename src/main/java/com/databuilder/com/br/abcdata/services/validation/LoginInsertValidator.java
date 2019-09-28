package com.databuilder.com.br.abcdata.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.databuilder.com.br.abcdata.controller.exceptions.FieldMessage;
import com.databuilder.com.br.abcdata.dto.LoginNewDTO;
import com.databuilder.com.br.abcdata.entity.Login;
import com.databuilder.com.br.abcdata.repositories.LoginRepository;

public class LoginInsertValidator implements ConstraintValidator<LoginInsert, LoginNewDTO> {

	@Autowired
	private LoginRepository reposit;
	
	@Override
	public void initialize(LoginInsert ann) {
	}

	@Override
	public boolean isValid(LoginNewDTO objDto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objDto.getStatusUsuario() == null) {
			list.add(new FieldMessage("statusUsuario", "Status não pode ser nulo"));
		}
		
		Optional<Login> aux = reposit.findByEmail(objDto.getEmail());
		if (aux != null) {
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