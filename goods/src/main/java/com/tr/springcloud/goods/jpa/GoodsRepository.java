package com.tr.springcloud.goods.jpa;

import com.tr.springcloud.goods.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author TR
 * @version 1.0
 * @date 8/21/2020 8:23 AM
 */
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
}