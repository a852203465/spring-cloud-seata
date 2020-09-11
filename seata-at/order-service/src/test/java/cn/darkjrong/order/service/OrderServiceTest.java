package cn.darkjrong.order.service;

import cn.darkjrong.order.OrderServiceApplicationTests;
import cn.darkjrong.order.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Rong.Jia
 * @date 2020/08/28 15:53
 */
class OrderServiceTest extends OrderServiceApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void findOne() {

        Order order = orderService.findOne(1L);
        System.out.println(order.toString());
    }
}