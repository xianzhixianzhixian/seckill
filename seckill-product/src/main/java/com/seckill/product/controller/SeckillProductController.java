package com.seckill.product.controller;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.request.SeckillResult;
import com.seckill.product.service.SeckillProductFeignService;
import com.seckill.product.service.impl.SeckillProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 商品秒杀服务controller
 */
@RestController
@RequestMapping("/seckillProduct")
public class SeckillProductController {

    @Autowired
    private SeckillProductFeignService seckillProductFeignService;
    @Autowired
    private SeckillProductServiceImpl seckillProductService;

    @PostMapping("/listProductByShopId")
    public SeckillResult listProductByShopId(Long shopId) {
        return new SeckillResult(seckillProductFeignService.listProductByShopId(shopId));
    }

    @PostMapping("/findProductByProductId")
    public SeckillResult findProductByProductId(Long productId) {
        return new SeckillResult(seckillProductFeignService.findProductByProductId(productId));
    }

    @PostMapping("/saveSeckillProduct")
    public SeckillResult saveSeckillProfduct(@RequestBody SeckillProduct seckillProduct) {
        return new SeckillResult(seckillProductService.saveSeckillProfduct(seckillProduct));
    }

    @PostMapping("/listAllSeckillProduct")
    public SeckillResult listAllSeckillProduct(Long shopId) {
        //查询商店申请中的商品
        return new SeckillResult(seckillProductService.listSeckillProduct(shopId, 0));
    }

    @PostMapping("/updateSeckillProductInfo")
    public SeckillResult updateSeckillProductInfo(Long id, Integer state) {
        SeckillProduct seckillProduct = new SeckillProduct();
        seckillProduct.setId(id);
        seckillProduct.setState(state);
        seckillProduct.setApproveTime(new Date());
        return new SeckillResult(seckillProductService.updateSeckillProductInfoSelective(seckillProduct));
    }

    @PostMapping("/listAllSeckillProductByState")
    public SeckillResult listAllSeckillProductByState(Long shopId, Integer state) {
        return new SeckillResult(seckillProductService.listSeckillProduct(shopId, state));
    }
}
