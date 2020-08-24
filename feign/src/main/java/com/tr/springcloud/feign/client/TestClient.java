package com.tr.springcloud.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author TR
 * @version 1.0
 * @date 2020/8/24 下午7:33
 */
@FeignClient(name = "goods-service")
public interface TestClient {

    @GetMapping("/goods-api/feign/{id}")
    String feignGoodsApi(@PathVariable Integer id);

    @GetMapping("/goods-api/buy")
    String goodsApiBuy();

}