package com.tr.springcloud.feign.client;

import com.tr.springcloud.feign.fallback.GoodsFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient
 * 用于微服务间调用，name指定调用服务名，fallback指定熔断回调
 *
 * @author TR
 * @version 1.0
 * @date 2020/8/24 下午7:33
 */
@FeignClient(name = "goods-service", fallback = GoodsFeignFallback.class)
public interface GoodsFeignClient {

    @GetMapping("/goods-api/feign/{id}")
    String feignGoodsApi(@PathVariable Integer id);

    @GetMapping("/goods-api/buy")
    String goodsApiBuy();

}