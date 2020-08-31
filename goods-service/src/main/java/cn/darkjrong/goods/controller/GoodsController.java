package cn.darkjrong.goods.controller;

import cn.darkjrong.goods.entity.Goods;
import cn.darkjrong.goods.service.GoodsService;
import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rong.Jia
 * @date 2020/08/28 16:22
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/add")
    public Map<String, Object>  addGoods () {

        Long goods = goodsService.saveGoods();

        Map<String, Object> result = CollectionUtil.newHashMap();
        result.put("code", 0);
        result.put("data", goods);

        return result;

    }












}
