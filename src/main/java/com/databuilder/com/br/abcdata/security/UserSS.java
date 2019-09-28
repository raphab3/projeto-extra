package com.databuilder.com.br.abcdata.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.databuilder.com.br.abcdata.entity.enums.NivelDeAcesso;
import com.databuilder.com.br.abcdata.entity.enums.PermissaoDeAcesso;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserSS implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String email;
	private String senha;
	private String nomeUsuario;
	private Integer nivelDeAcesso;
	private Collection<? extends GrantedAuthority> authorities;

	public UserSS(Integer id, String email, String senha, String nomeUsuario, NivelDeAcesso nivelDeAcesso, Set<PermissaoDeAcesso> permissoes) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nomeUsuario = nomeUsuario;
		this.nivelDeAcesso = nivelDeAcesso.getCodigo();
		this.authorities = permissoes.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
	}
	
	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public boolean hasHole(PermissaoDeAcesso permissaoDeAcesso) {
		return getAuthorities().contains(new SimpleGrantedAuthority(permissaoDeAcesso.getDescricao()));
	}

	public Integer getNivelDeAcesso() {
		return nivelDeAcesso;
	}
	
}
