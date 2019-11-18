package com.seckill.product.service;

import com.seckill.common.bean.ManagerProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 使用feign去调用manager-product项目中的接口
 */
@FeignClient(value = "manager-product")
public interface SeckillProductService {

    /**
     * 根据商店id查询商品列表
     * @param shopid
     * @return
     */
    @PostMapping("/product/listProductByShopId")
    public List<ManagerProductInfo> listProductByShopId(Long shopid);

}
