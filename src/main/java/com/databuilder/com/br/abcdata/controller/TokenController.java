package com.databuilder.com.br.abcdata.controller;

import static com.databuilder.com.br.abcdata.utils.ConstantesPaths.TOKENS;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.databuilder.com.br.abcdata.config.property.AbcdataProperty;
import com.databuilder.com.br.abcdata.utils.ConstantesTags;

import io.swagger.annotations.Api;

@RestController
@Api(value = TOKENS, produces = MediaType.APPLICATION_JSON_VALUE, tags = {ConstantesTags.TAG_TOKEN})
@RequestMapping(value = TOKENS, produces = MediaType.APPLICATION_JSON_VALUE)
public class TokenController {

	@Autowired
	private AbcdataProperty abcdataProperty;
	
	@DeleteMapping("/revoke")
	public void revoke(HttpServletRequest req, HttpServletResponse resp) {
		Cookie cookie = new Cookie("refreshToken", null);
		cookie.setHttpOnly(true);
		cookie.setSecure(abcdataProperty.getSeguranca().isEnableHttps()); 
		cookie.setPath(req.getContextPath() + "/oauth/token");
		cookie.setMaxAge(0);
		
		resp.addCookie(cookie);
		resp.setStatus(HttpStatus.NO_CONTENT.value());
		
	}
}
