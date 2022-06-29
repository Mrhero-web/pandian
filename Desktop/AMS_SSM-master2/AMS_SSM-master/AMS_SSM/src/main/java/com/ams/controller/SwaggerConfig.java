package com.ams.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("瓤瓤")
                .select()
                .apis(RequestHandlerSelectors.basePackage("你所要扫描的controller包"))
                .build();
    }

    private ApiInfo apiInfo(){
        Contact contact=new Contact("眠不觉","https://blog.csdn.net/","2190175238@qq.com");
        return new ApiInfo(
                "瓤瓤",
                "你我山巅自相逢,予你与我遇清风",
                "1.0",
                "https://swagger.io/",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>()
        );
    }
}