package com.databuilder.com.br.abcdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.databuilder.com.br.abcdata.config.property.AbcdataProperty;

@SpringBootApplication
@EnableConfigurationProperties(AbcdataProperty.class)
public class AbcdataApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(AbcdataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		
	}
}
