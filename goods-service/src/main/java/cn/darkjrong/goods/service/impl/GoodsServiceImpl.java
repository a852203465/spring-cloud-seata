package cn.darkjrong.goods.service.impl;

import cn.darkjrong.goods.entity.Goods;
import cn.darkjrong.goods.mapper.GoodsMapper;
import cn.darkjrong.goods.service.GoodsService;
import cn.hutool.core.date.DateUtil;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rong.Jia
 * @date 2020/08/28 16:01
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Goods findOne(Long id) {
        return goodsMapper.selectById(id);
    }

    @Override
    @GlobalTransactional(rollbackFor = RuntimeException.class)
    public Long saveGoods() {

        Goods goods = new Goods();
        goods.setCreateTime(DateUtil.current(Boolean.FALSE));
        goods.setIsDeleted((byte)0);
        goods.setMoney(1000L);
        goods.setName("笔记本");
        goods.setStockNum(200L);

        goodsMapper.insert(goods);

        throw new RuntimeException("分布式事务测试");

    }
}
