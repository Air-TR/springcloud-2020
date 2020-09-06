package com.tr.springcloud.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * 经查:Zipkin 在SpringBoot2.2.X 以上版本集成好像有问题
 * 目前方案采用官方推荐方式，单独运行官网提供的服务，链接：https://zipkin.io/pages/quickstart.html
 *
 * @author TR
 * @date 2020/9/6 上午1:57
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

}
