package com.seckill.manager.product.controller;

import com.seckill.common.request.SeckillResult;
import com.seckill.manager.product.service.impl.ProductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @PostMapping(value = "/listProductByShopId")
    public SeckillResult listProductByShopId(Long shopId) {
        return new SeckillResult(productInfoService.listProductInfo(shopId, 1));
    }

    @PostMapping(value = "/findProductByProductId")
    public SeckillResult findProductByProductId(Long productId) {
        return new SeckillResult(productInfoService.findProductByProductId(productId));
    }
}
