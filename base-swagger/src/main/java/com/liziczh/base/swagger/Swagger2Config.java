package com.liziczh.base.swagger;

import org.springframework.beans.factory.annotation.Value;
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

/**
 * SwaggerConfig
 *
 * @author chenzhehao
 * @version 1.0
 * @description
 * @date 2022/1/16 12:50 下午
 */
@EnableSwagger2
@Configuration
public class Swagger2Config {

    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.liziczh";
    public static final String ONLINE_ENV = "online";

    @Value("${spring.profiles.active}")
    private String env;

    @Bean
    public Docket docket() {
        Docket docket = null;
        if (!ONLINE_ENV.equals(env)) {
            docket = new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                    .paths(PathSelectors.any())
                    .build();
        } else {
            docket = new Docket(DocumentationType.SWAGGER_2)
                    .apiInfo(apiInfo())
                    .select()
                    .apis(RequestHandlerSelectors.none())
                    .build();
        }
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Archetype REST API")
                .description("Swagger API")
                .contact(new Contact("栗子", "https://github.com/liziczh", "liziczh@foxmail.com"))
                .version("1.0")
                .build();
    }
}
