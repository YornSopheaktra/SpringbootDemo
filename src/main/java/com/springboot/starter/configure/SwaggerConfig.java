package com.springboot.starter.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.UnknownHostException;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() throws UnknownHostException {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.springboot.starter.ws.controller"))
                .paths(PathSelectors.ant("/**"))
                .build()
                .apiInfo(apiEndPointsInfo());
    }
    /*v2.6.1
    private ApiInfo apiEndPointsInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot Starter",
                "Spring Boot Starter description about this API.",
                "v0.1",
                "Terms of service",
                new Contact("Sopheaktra", "https://swagger.io/swagger-ui", "sopheaktra.yor@ascendcorp.com"),
                "License of API",
                "API license URL");
        return apiInfo;
    }*/

    /*
        v2.8.0
     */
    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("Spring Boot Starter")
                .description("Spring Boot Starter description about this API.")
                .contact(new Contact("Sopheaktra", "https://swagger.io/swagger-ui", "sopheaktra.yor@ascendcorp.com"))
                .license("License of API Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("v0.1")
                .build();

    }
}
