package com.springboot.restapi.web.SpringBootRestAPI;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.springboot.restapi")
@EnableSwagger2
public class SpringBootRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/employees/*"))
				.apis(RequestHandlerSelectors.basePackage("com.springboot.restapi.web"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails(){
		return new ApiInfo(
				"Employee API", 
				"API for Employee Information", 
				"1.0", 
				"Free to Use", 
				new springfox.documentation.service.Contact("Sunishnat Sinha", "http://www.abc.com", "ab@c.com"), 
				"API License", 
				"http://www.abc.com",
				Collections.emptyList());
	}

}
