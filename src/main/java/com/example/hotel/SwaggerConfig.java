package com.example.hotel;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error.*"))).build().apiInfo(apiInfo());
	}


	private ApiInfo apiInfo() {            
    	return new ApiInfo("HotelManagement", "Hotel Room booking system for rooms RESTful api documentation", "1", "terms",                  
    			new Contact("Squad-2", "www.hotelroom.com", "support@irctc.com"), "license number", "lecence url", Collections.emptyList());     
    }
}
