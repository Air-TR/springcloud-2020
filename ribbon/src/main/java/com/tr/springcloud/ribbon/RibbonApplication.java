package com.tr.springcloud.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/goods/pay")
    public String goodsApi(String serviceName) {
        //方法1.注入HttpServletRequest拿到地址，根据地址来判断访问哪一个服务.
        String url = "";
        url = request.getScheme() +"://" + request.getServerName()
                + ":" +request.getServerPort()
                + request.getServletPath();
        if (request.getQueryString() != null){
            url += "?" + request.getQueryString();
        }
        //方法2.将服务的名称作为参数传入到url中，在方法中获取到，通过@RequestParam拿到
        //此方法需要url为 http://runtao.exigengroup.com:8101/goods/pay?serviceName=pay
        String name = serviceName;
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
