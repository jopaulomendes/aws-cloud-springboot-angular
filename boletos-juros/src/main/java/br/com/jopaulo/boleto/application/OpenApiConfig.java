package br.com.jopaulo.boleto.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpemApi() {
		 return new OpenAPI()
	                .info(new Info()
	                        .title("API Juros Boleto")
	                        .description("API para calcular juros e de um boleto vencido")
	                        .contact(new Contact().name("João Paulo da Mata Mendes").email("jp_cbc@hotmail.com"))
	                        .version("1.0.0"));
	}
}
