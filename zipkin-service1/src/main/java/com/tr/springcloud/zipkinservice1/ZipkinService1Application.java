package com.tr.springcloud.zipkinservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinService1Application {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinService1Application.class, args);
    }

    /**
     * 写在 Controller 类中可实现功能,但是在 Zipkin 管理页面看到的是分开两次独立的调用,
     * 配置在这里,在 Zipkin 管理页面中是一次(里面包含两次)的调用,
     * 具体原因不详
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/call/zipkin-service2/service-name")
    public String callZipkinService2() {
        return restTemplate().getForObject("http://localhost:9002/zipkin-service2/service-name", String.class);
    }

}
