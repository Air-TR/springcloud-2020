package com.tr.springcloud.goods.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TR
 * @version 1.0
 * @date 8/20/2020 4:03 PM
 */
@RestController
public class GoodsController {

    @GetMapping("/buy")
    public String buy() {
        return "Goods03 Buy Success!";
    }

    @GetMapping("/pay")
    public String pay() {
        return "Goods03 Pay Success!";
    }

}
