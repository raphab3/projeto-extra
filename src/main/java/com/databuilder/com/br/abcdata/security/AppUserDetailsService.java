package com.databuilder.com.br.abcdata.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.databuilder.com.br.abcdata.entity.Login;
import com.databuilder.com.br.abcdata.repositories.LoginRepository;


@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Optional<Login> loginOptional = loginRepository.findByEmail(email);
		Login login = loginOptional.orElseThrow(() -> new UsernameNotFoundException("Login e/ou senha incorretos !!"));
		
		return new UserSS(login.getId(), login.getEmail(), login.getSenha(), login.getNomeUsuario(), login.getNivelDeAcesso(), login.getPermissaoDeAcesso());
	}

}
