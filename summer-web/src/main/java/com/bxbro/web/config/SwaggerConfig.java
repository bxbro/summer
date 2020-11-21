package com.bxbro.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description Swagger配置类
 * @Author dong
 * @Date 2020/11/21
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean swaggerSwitch;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Summer is coming")
                .description("this is the restful api document of Summer")
                .contact(new Contact("danieldong", "https://github.com/Danieldong0802", "1756330108@qq.com"))
                .version("1.0.0")
                .build();
    }


    /**
     *@Description 通过createRestApi方法来构建一个DocketBean
     *@Author dong
     *@Date 2020/11/21
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerSwitch)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bxbro.web.controller"))
                .build();
    }


}
