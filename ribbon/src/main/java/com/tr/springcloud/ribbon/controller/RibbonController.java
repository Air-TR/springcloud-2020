/*
package com.tr.springcloud.ribbon.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

*/
/**
 * @author TR
 * @version 1.0
 * @date 8/20/2020 4:12 PM
 *//*

@RestController
public class RibbonController {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String serviceName;

    @GetMapping("/")
    public String index() {
        return restTemplate().getForObject("http://goods-service/", String.class);
    }

}
*/
