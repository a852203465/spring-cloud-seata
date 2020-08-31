package cn.darkjrong.order.service.impl;

import cn.darkjrong.order.entity.Order;
import cn.darkjrong.order.mapper.OrderMapper;
import cn.darkjrong.order.remote.GoodsRemote;
import cn.darkjrong.order.service.OrderService;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import com.baomidou.mybatisplus.extension.api.R;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Rong.Jia
 * @date 2020/08/28 15:51
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsRemote goodsRemote;

    @Override
    public Order findOne(Long id) {

        return orderMapper.selectById(id);
    }

    @Override
    @GlobalTransactional(rollbackFor = RuntimeException.class)
    public void addOrder() {

        Map<String, Object> goods = goodsRemote.addGoods();
        Long goodsId = null;
        if (Validator.equal(0L, Convert.toLong(goods.get("code")))) {
            goodsId  = Convert.toLong(goods.get("data"));
        }else {
            throw new RuntimeException("分布式事务测试");
        }

        Order order = new Order();
        order.setCreateTime(DateUtil.current(Boolean.FALSE));
        order.setGoodsId(goodsId);
        order.setOrderNo("12211321");
        order.setIsDeleted((byte)0);
        order.setUserId(1231312L);

        orderMapper.insert(order);

    }
}
