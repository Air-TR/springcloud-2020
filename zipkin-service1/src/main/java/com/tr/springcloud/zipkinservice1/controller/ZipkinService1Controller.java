package com.tr.springcloud.zipkinservice1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TR
 * @version 1.0
 * @date 2020/9/6 下午3:09
 */
@RestController
public class ZipkinService1Controller {

    @Value("${spring.application.name}")
    String serviceName;

    @GetMapping("/service-name")
    public String getServiceName() {
        return serviceName;
    }

}
