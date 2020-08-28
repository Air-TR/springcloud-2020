//package com.tr.springcloud.hystrix;
//
//import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.Arrays;
//
///**
// * @author TR
// * @version 1.0
// * @date 8/21/2020 3:09 PM
// */
//@DefaultProperties(defaultFallback = "defaultFallback")
//@RestController
//public class HystrixController {
////    @GetMapping("/getProductInfoList")
////    @HystrixCommand(fallbackMethod = "fallback", commandProperties =
////            {
////                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
////            })
////    public String getProductInfoList() {
////        RestTemplate restTemplate = new RestTemplate();
////        return restTemplate.postForObject("http://127.0.0.1:8003/product/listForOrder",
////                Arrays.asList("123"),
////                String.class);
////    }
////
////    private String fallback() {
////        return "Define Fall Back";
////    }
//
//    private String defaultFallback() {
//        return "Default Fall Back";
//    }
//}