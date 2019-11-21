package com.seckill.product.service;

import com.seckill.common.bean.ManagerProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 使用feign去调用manager-product项目中的接口
 */
@FeignClient(value = "manager-product")
public interface SeckillProductService {

    /**
     * 根据商店id查询商品列表
     * @param shopId
     * @return
     */
    @PostMapping("/product/listProductByShopId")
    public List<ManagerProductInfo> listProductByShopId(Long shopId);

    /**
     * 根据商品id查询商品信息
     * @param productId
     * @return
     */
    @PostMapping("/product/findProductByProductId")
    public ManagerProductInfo findProductByProductId(Long productId);

}
