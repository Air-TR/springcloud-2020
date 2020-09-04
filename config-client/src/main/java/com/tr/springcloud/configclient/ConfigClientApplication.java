package com.tr.springcloud.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 本项目配置了 config-client 和 cloud-bus
 * cloud-bus 配置参考 Controller 类,另外还有 配置文件相关配置 和 pom 依赖包引入
 *
 * 测试发现 @EnableEurekaClient 可以不配置,不影响效果,不知道是不是 @EnableEurekaClient 在微服务中都可以不配置,被默认继承了？？
 *
 * @author TR
 * @date 2020/9/5 上午2:34
 */
@SpringBootApplication
//@EnableEurekaClient
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
