package com.tr.springcloud.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RefreshScope
public class BusApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusApplication.class, args);
    }

    @Value("${title}")
    String title;

    @GetMapping("/config/title")
    public String getTitle(){
        return title;
    }

}
