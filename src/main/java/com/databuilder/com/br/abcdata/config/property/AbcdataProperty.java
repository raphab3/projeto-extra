package com.databuilder.com.br.abcdata.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties("abcdata")
public class AbcdataProperty {

	@Getter
	@Setter
	private String originPermitida = "http://localhost:4200";
	
	@Getter
	private final Seguranca seguranca = new Seguranca();

	@Getter
	@Setter
	public static class Seguranca {

		private boolean enableHttps;

	}
}
