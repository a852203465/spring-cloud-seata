package cn.darkjrong.goods.service;

import cn.darkjrong.goods.GoodsServiceApplicationTests;
import cn.darkjrong.goods.entity.Goods;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rong.Jia
 * @date 2020/08/28 16:02
 */
class GoodsServiceImplTest extends GoodsServiceApplicationTests {

    @Autowired
    private GoodsService goodsService;

    @Test
    void findOne() {

        Goods goods = goodsService.findOne(1L);
        System.out.println(goods.toString());
    }



}