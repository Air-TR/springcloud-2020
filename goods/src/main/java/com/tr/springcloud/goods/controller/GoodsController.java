package com.tr.springcloud.goods.controller;

import com.tr.springcloud.goods.entity.Goods;
import com.tr.springcloud.goods.jpa.GoodsRepository;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author TR
 * @version 1.0
 * @date 8/20/2020 4:03 PM
 */
@Api(tags = "Goods")
@RestController
public class GoodsController {

    @Resource
    private GoodsRepository goodsRepository;

    @GetMapping("/goods/{id}")
    public Goods getOne(@PathVariable Integer id) {
        /**
         * 不要使用 getOne() 方法！！！
         * 用 findById().get()
         */
        return goodsRepository.findById(id).get();
    }

    @PostMapping("/goods")
    public void save(@RequestBody Goods goods) {
        goodsRepository.save(goods);
    }

    @GetMapping("/goods")
    public List<Goods> finaAll() {
        return goodsRepository.findAll();
    }

    @DeleteMapping("/goods/{id}")
    public void delete(@PathVariable Integer id) {
        goodsRepository.deleteById(id);
    }

    @GetMapping("/feign/{id}")
    public String goodsFeign(@PathVariable Integer id) {
        return goodsRepository.getOne(id).getName();
    }


    // ---------- 测试负载均衡 ----------
    @GetMapping("/buy")
    public String buy() {
        return "Goods Buy Success!";
    }

    @GetMapping("/pay")
    public String pay() {
        return "Goods Pay Success!";
    }

}
