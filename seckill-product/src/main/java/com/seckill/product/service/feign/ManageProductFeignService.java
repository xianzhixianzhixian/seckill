package com.seckill.product.service.feign;

import com.seckill.common.bean.ManagerProductDetail;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 使用feign去调用manager-product项目中的接口
 */
@FeignClient(value = "manager-product")
public interface ManageProductFeignService {

    /**
     * 根据商店id查询商品列表
     * @param shopId
     * @return
     */
    @PostMapping("/product/listProductByShopId")
    List<SeckillProduct> listProductByShopId(@RequestParam("shopId") Long shopId);

    /**
     * 根据商品id查询商品信息
     * @param productId
     * @return
     */
    @PostMapping("/product/findProductByProductId")
    SeckillResult findProductByProductId(@RequestParam("productId") Long productId);

    /**
     * 根据商品id查询商品详情
     * @param productId
     * @return
     */
    @PostMapping("/product/findProductDetailByProductId")
    ManagerProductDetail findProductDetailByProductId(@RequestParam("productId") Long productId);

}
