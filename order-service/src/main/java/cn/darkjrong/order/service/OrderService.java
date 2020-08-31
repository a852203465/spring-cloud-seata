package cn.darkjrong.order.service;

import cn.darkjrong.order.entity.Order;

/**
 * @author Rong.Jia
 * @date 2020/08/28 15:50
 */
public interface OrderService {

    Order findOne(Long id);

    void addOrder();




}
