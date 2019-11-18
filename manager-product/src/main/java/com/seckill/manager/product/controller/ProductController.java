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
    public List<ManagerProductInfo> listProductByShopId(Long shopid) {
        List<ManagerProductInfo> list = productInfoService.listProductInfo(shopid);
        return list;
    }

    @PostMapping(value = "/findProductByProductId")
    public ManagerProductInfo findProductById(Long id){
        return productInfoService.findProductById(id);
    }
}
