package com.tr.springcloud.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试发现 Bus 就是一个配置,不需要单独起一个服务,哪个服务需要分布式配置就可以在那个服务里单独配 Bus
 *
 * @author TR
 * @date 2020/9/5 上午2:07
 */
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
