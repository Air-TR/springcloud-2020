package com.tr.springcloud.feign.controller;

import com.tr.springcloud.feign.client.TestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author TR
 * @version 1.0
 * @date 2020/8/24 下午7:38
 */
@RestController
public class FeignController {

    @Resource
    private TestClient testClient;

    @GetMapping("/test-feign")
    public String testFeign1() {
        return "test-feign yes";
    }

    @GetMapping("/goods/{id}")
    public String feignGoodsApi(@PathVariable Integer id) {
        return testClient.feignGoodsApi(id);
    }

    @GetMapping("/goods/buy")
    public String goodsApiBuy() {
        return testClient.goodsApiBuy();
    }

}
