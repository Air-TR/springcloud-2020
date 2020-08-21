package com.tr.springcloud.goods;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .tags(new Tag("Goods", "商品"), getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tr.springcloud.goods.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private Tag[] getTags() {
        Tag[] tags = {
//                new Tag("Transaction", "事务"),
        };
        return tags;
    }

    private ApiInfo apiInfo() {
//        Contact contact = new Contact("TR", "http://www.google.com/", "tr1838@163.com");
        return new ApiInfoBuilder()
                .title("SpringCloud-2020")
                .description("Goods Service API")
//                .termsOfServiceUrl("http://www.baidu.com/")
//                .contact(contact)
                .version("1.0")
                .build();
    }

}
