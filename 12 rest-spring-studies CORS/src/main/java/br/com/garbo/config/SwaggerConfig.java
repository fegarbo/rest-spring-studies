package br.com.garbo.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //To the component scan see that this is a config class and must be initialized
@EnableSwagger2
public class SwaggerConfig {
	
	//Select all controllers and paths to initialize configurations with swagger2
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.garbo")) //Generate documentation from this package
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("RESTful API with Spring Boot 2.1.3",
				"Some description about your API.",
				"v1",
				"Terms of Service Url",
				new Contact("Fernando Garbo", "https://www.linkedin.com/in/fernandogarbo/", "nando.garbo@gmail.com"),
				"License of API", "License URL", Collections.emptyList());
	}
}
