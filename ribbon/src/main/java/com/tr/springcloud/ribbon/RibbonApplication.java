package com.tr.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    @Autowired
    HttpServletRequest request;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;

    @RequestMapping("/goods/**")
    public ResponseEntity goodsApi() {
        String url = "http://goods-service";
        url += request.getRequestURI();
        if (request.getQueryString() != null) {
            url += "?" + request.getQueryString();
        }
        return restTemplate().getForEntity(url, Object.class, (Object) null);
//        return restTemplate().getForObject(url, String.class);
    }

//    @GetMapping("/order")
//    public String orderApi() {
//        return restTemplate().getForObject("http://goods-service/order", String.class);
//    }

}
