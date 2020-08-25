package com.tr.springcloud.feign.fallback;

import com.tr.springcloud.feign.client.GoodsFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author TR
 * @version 1.0
 * @date 8/25/2020 8:39 AM
 */
@Component
public class GoodsFeignFallback implements GoodsFeignClient {

    @Override
    public String feignGoodsApi(Integer id) {
        return "调用 goods-service 失败";
    }

    @Override
    public String goodsApiBuy() {
        return "调用 /goods-api/buy 失败";
    }
}
