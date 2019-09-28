package com.databuilder.com.br.abcdata.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.databuilder.com.br.abcdata.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		
		
			 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			 
//			 UserSS user1 = (UserSS) authentication.getPrincipal();
			 
//			 System.out.println("EM UserService Retornou: " + user1.getNomeUsuario());
			 
			return (UserSS) authentication.getPrincipal();	
			
	
	}
}
