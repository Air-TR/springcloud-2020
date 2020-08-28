package com.tr.springcloud.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 9:41 AM
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFail")
public class GoodsHystrixController {

    @HystrixCommand(fallbackMethod = "fail1")
    @GetMapping("/goods-api/buy")
    public String buy() {
        throw new RuntimeException();
    }

    @HystrixCommand(fallbackMethod = "fail2")
    @GetMapping("/goods-api/pay")
    public String pay() {
        throw new RuntimeException();
    }

    @HystrixCommand
    @GetMapping("/goods-api/goods/{id}")
    public String goodsTest(@PathVariable Integer id) {
        System.out.println("id = " + id);
        throw new RuntimeException();
    }

    private String fail1() {
        System.out.println("fail1");
        return "fail1";
    }

    @HystrixCommand(fallbackMethod = "fail3")
    private String fail2() {
        System.out.println("fail2");
        throw new RuntimeException();
    }

    @HystrixCommand
    private String fail3() {
        System.out.println("fail3");
        throw new RuntimeException();
    }

    private String defaultFail() {
        System.out.println("default fail");
        return "default fail";
    }

}