package cn.darkjrong.goods.service;

import cn.darkjrong.goods.entity.Goods;

/**
 * @author Rong.Jia
 * @date 2020/08/28 16:00
 */
public interface GoodsService {

    Goods findOne(Long id);

    Long saveGoods();





}
