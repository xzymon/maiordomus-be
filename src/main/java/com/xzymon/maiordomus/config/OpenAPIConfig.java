package com.xzymon.maiordomus.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				       .components(new Components())
				       .info(new Info()
						             .title("Maiordomus API")
						             .description("Dokumentacja API dla Maiordomus.")
						             .version("1.0.0")
						             .contact(new Contact()
								                      .name("Dev Support")
								                      .email("support@dev")));
	}
}
