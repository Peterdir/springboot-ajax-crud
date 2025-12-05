package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.example.config.StorageProperties;
import com.example.service.StorageService;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class DemoSpringboot1Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringboot1Application.class, args);
	}

	/**
	 * ✅ Cấu hình OpenAPI (thay thế cho Docket của Springfox)
	 */
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("DemoSpringboot1 API")
						.version("1.0.0")
						.description("API Documentation for DemoSpringboot1 Application")
						.contact(new Contact()
								.name("Duy Lâm Khánh")
								.email("duy@example.com"))
						.license(new License()
								.name("Apache 2.0")
								.url("http://springdoc.org")));
	}

	/**
	 * ✅ Cấu hình StorageService (giữ nguyên)
	 */
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return args -> storageService.init();
	}
}
