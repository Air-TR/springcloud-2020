package com.tr.springcloud.zipkinservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinService2Application {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinService2Application.class, args);
    }

    /**
     * 为什么这一段写在 Controller 类中就没用,在 Zipkin 管理页面看到的就是分开两次独立的调用
     * 配置在这里,在 Zipkin 管理页面中是一次(里面包含两次)的调用,
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/call/zipkin-service1/service-name")
    public String callZipkinService1() {
        return restTemplate().getForObject("http://localhost:9001/zipkin-service1/service-name", String.class);
    }

}
