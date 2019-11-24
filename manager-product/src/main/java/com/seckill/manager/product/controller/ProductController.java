package com.seckill.manager.product.controller;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.manager.product.service.impl.ProductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @PostMapping(value = "/listProductByShopId")
    public List<ManagerProductInfo> listProductByShopId(Long shopId) {
        List<ManagerProductInfo> list = productInfoService.listProductInfo(shopId, 1);
        return list;
    }

    @PostMapping(value = "/findProductByProductId")
    public ManagerProductInfo findProductByProductId(Long productId) {
        return productInfoService.findProductByProductId(productId);
    }
}
