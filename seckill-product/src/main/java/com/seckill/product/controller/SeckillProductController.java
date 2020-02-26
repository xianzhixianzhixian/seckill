package com.seckill.product.controller;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillResult;
import com.seckill.product.service.feign.ManageProductFeignService;
import com.seckill.product.service.impl.SeckillProductServiceImpl;
import com.seckill.product.service.impl.SeckillProductStrategyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 商品秒杀服务controller
 */
@RestController
@RequestMapping("/seckillProduct")
public class SeckillProductController {

    @Autowired
    private ManageProductFeignService manageProductFeignService;
    @Autowired
    private SeckillProductServiceImpl seckillProductService;
    @Autowired
    private SeckillProductStrategyServiceImpl seckillProductStrategyService;

    @PostMapping("/listProductByShopId")
    public SeckillResult listProductByShopId(Long shopId) {
        return new SeckillResult(manageProductFeignService.listProductByShopId(shopId));
    }

    @PostMapping("/findProductByProductId")
    public SeckillResult findProductByProductId(Long productId) {
        return new SeckillResult(manageProductFeignService.findProductByProductId(productId));
    }

    @PostMapping("/findSeckillProductBySeckillProductId")
    public SeckillProduct findSeckillProductBySeckillProductId(@RequestParam("seckillProductId") Long seckillProductId) {
        return seckillProductService.findSeckillProductBySeckillProductId(seckillProductId);
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
        return new SeckillResult(seckillProductService.updateSeckillProductByPrimaryKeySelective(seckillProduct));
    }

    @PostMapping("/listAllSeckillProductByState")
    public SeckillResult listAllSeckillProductByState(Long shopId, Integer state) {
        return new SeckillResult(seckillProductService.listSeckillProduct(shopId, state));
    }

    @PostMapping("/setSeckillProductStrategy")
    public SeckillResult setSeckillProductStrategy(@RequestParam("strategyName") String strategyName,@RequestParam("strategyValue") String strategyValue) {
        return new SeckillResult(seckillProductStrategyService.setSeckillProductStrategy(strategyName, strategyValue));
    }

}
