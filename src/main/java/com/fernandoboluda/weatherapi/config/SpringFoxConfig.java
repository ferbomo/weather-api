package com.fernandoboluda.weatherapi.config;

import static java.util.Collections.emptyList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig {

  @Bean
  public Docket apiDocket() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors
            .basePackage("com.fernandoboluda.weatherapi.adapters.primary.rest"))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(getApiInfo());
  }

  private ApiInfo getApiInfo() {
    return new ApiInfo(
        "Weather Service API",
        "Weather Service API Description",
        "1.0",
        "http://fernandoboluda.com/terms",
        new Contact("fernandoboluda", "https://fernandoboluda.com", "apis@fernandoboluda.com"),
        "LICENSE",
        "LICENSE URL",
        emptyList()
    );
  }
}