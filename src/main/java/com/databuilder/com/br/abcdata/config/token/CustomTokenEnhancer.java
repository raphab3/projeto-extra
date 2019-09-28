package com.databuilder.com.br.abcdata.config.token;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.databuilder.com.br.abcdata.security.UserSS;

public class CustomTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
	
		UserSS usuarioSistema = (UserSS) authentication.getPrincipal();

		// System.out.println(" No CustomTokenEnhacer RECEBEU: " + usuarioSistema.getId() + " | " + usuarioSistema.getUsername() + " | " + usuarioSistema.getPassword());
		
		Map<String, Object> addInfo = new HashMap<>();
		addInfo.put("id", usuarioSistema.getId());
		addInfo.put("email", usuarioSistema.getUsername());
		addInfo.put("nome", usuarioSistema.getNomeUsuario());
		addInfo.put("niveldeacesso:", usuarioSistema.getNivelDeAcesso());
		
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(addInfo);
		return accessToken;
	}
}
