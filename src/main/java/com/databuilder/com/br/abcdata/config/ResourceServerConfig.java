package com.databuilder.com.br.abcdata.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;

@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private Environment env;

	private static final String[] PUBLIC_MATCHERS = { 
			"/h2-console/**", 
	
			// Swagger 
			"/v2/api-docs", 
			"/configuration/ui", 
			"/swagger-resources/**", 
			"/configuration/**",
			"/swagger-ui.html", 
			"/webjars/**"
	};
	
	private static final String[] PUBLIC_MATCHERS_GET = {

	};

	private static final String[] PUBLIC_MATCHERS_POST = {

	};

	@Override
	public void configure(HttpSecurity http) throws Exception {

		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers()
			    .frameOptions()
			    .disable();
		}

		http.authorizeRequests()
					.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
					.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
					.antMatchers(PUBLIC_MATCHERS).permitAll()
					.anyRequest().authenticated()
				.and()
					.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
					.csrf().disable();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			resources.stateless(true);
	}


	@Bean
	public MethodSecurityExpressionHandler createExpressionHandler() {
		return new OAuth2MethodSecurityExpressionHandler();
		}

}
