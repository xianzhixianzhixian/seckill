package com.seckill.manager.product.controller;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.common.request.SeckillCodeMapping;
import com.seckill.common.request.SeckillResult;
import com.seckill.manager.product.service.impl.ProductInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductManageController {

    private static final Logger logger = LoggerFactory.getLogger(ProductManageController.class);

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @PostMapping("/listProduct")
    public SeckillResult listProduct(Long shopId, Integer state) {
        try {
            List<ManagerProductInfo> list = productInfoService.listProductInfo(shopId, state);
            return new SeckillResult(list);
        } catch (Exception e) {
            logger.error("查询商品信息列表错误，原因{}", e);
            return new SeckillResult(SeckillCodeMapping.SYSTEM_ERROR, "查询商品信息列表错误", e);
        }
    }

    @PostMapping("/updateState")
    public SeckillResult updateState(Long id, Integer state) {
        try {
            ManagerProductInfo productInfo = new ManagerProductInfo();
            productInfo.setId(id);
            productInfo.setState(state);
            return new SeckillResult(productInfoService.updateProductInfo(productInfo));
        } catch (Exception e) {
            logger.error("更新商户状态错误，原因{}", e);
            return new SeckillResult(SeckillCodeMapping.SYSTEM_ERROR, "更新商户状态错误", e);
        }
    }
}
