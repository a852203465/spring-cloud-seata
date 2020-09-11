package cn.darkjrong.order.remote;

import cn.darkjrong.order.remote.fallback.GoodsRemoteFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient(value = "goods-serivce", fallbackFactory = GoodsRemoteFallbackFactory.class)
 public interface GoodsRemote {

    @GetMapping("/add")
    Map<String, Object> addGoods ();

















}
