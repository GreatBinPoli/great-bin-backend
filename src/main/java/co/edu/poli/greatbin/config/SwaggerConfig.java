package co.edu.poli.greatbin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * Configuracion e Swagger 
 * @author Johnny Masmela 
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket customerApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.basePackage("co.edu.poli.greatbin.controller")) //Specific package
				.apis(RequestHandlerSelectors.basePackage("co.edu.poli")) //All project
				//.paths(PathSelectors.regex("/api/v1.*")) //filter RequestMapping with regular expression
				.paths(PathSelectors.any())
				.build()
				.apiInfo(greatApiInfo());
				//.tags(new Tag("Class: Controller", "*** Customer Controller ***"));
	}

	private ApiInfo greatApiInfo() {
		return new ApiInfoBuilder()
				.title("My Spring Boot REST API")
				.description(" REST API")
				.contact(new Contact("Web great ", "", "jmarmela@poligran.edu.co,cfesanchez@poligran.edu.co,anipinzon@poligran.edu.co"))
				.version("0.0.1")
				.build();
	}
}
