package cn.darkjrong.order.remote.fallback;

import cn.darkjrong.order.remote.GoodsRemote;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 运维服务 回退类
 *
 * @author Rong.Jia
 * @date 2020/8/18 17:22
 */
@Slf4j
@Component
public class GoodsRemoteFallbackFactory implements FallbackFactory<GoodsRemote> {


    @Override
    public GoodsRemote create(Throwable throwable) {
        return new GoodsRemote() {
            @Override
            public Map<String, Object> addGoods() {

                Map<String, Object> map = new HashMap<>();
                map.put("code", -1);

                return map;
            }
        };
    }
}
