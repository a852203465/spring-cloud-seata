package cn.darkjrong.order.controller;

import cn.darkjrong.order.service.OrderService;
import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Rong.Jia
 * @date 2020/08/28 16:22
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/add")
    public Map<String, Object>  addGoods () {

        orderService.addOrder();

        Map<String, Object> result = CollectionUtil.newHashMap();
        result.put("code", 0);

        return result;

    }












}
