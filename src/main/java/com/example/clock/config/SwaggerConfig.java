package com.example.clock.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI config() {
		return new OpenAPI()
				.info(new Info()
                        .title("Speaking Clock API")
                        .version("1.0")
                        .description("API documentation for Speaking Clock"));

	}

}
