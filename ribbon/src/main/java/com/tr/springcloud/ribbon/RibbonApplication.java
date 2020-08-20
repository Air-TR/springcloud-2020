package com.tr.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;

    @GetMapping("/goods/pay")
    public String goodsApi() {
        return restTemplate().getForObject("http://goods-service/goods/pay", String.class);
    }

    @GetMapping("/goods/buy")
    public String goodsApiBuy() {
        return restTemplate().getForObject("http://goods-service/goods/buy", String.class);
    }

//    @GetMapping("/order")
//    public String orderApi() {
//        return restTemplate().getForObject("http://goods-service/order", String.class);
//    }

}
