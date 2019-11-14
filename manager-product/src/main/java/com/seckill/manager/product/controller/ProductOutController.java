package com.seckill.manager.product.controller;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.manager.product.service.impl.ProductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductOutController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @RequestMapping(value = "/listProductByShopId",method = RequestMethod.POST)
    public List<ManagerProductInfo> listProductby(Long shopid, Model model) {
        List<ManagerProductInfo> list = productInfoService.listProductInfo(shopid);
        return list;
    }

    @RequestMapping(value = "/findProductByProductId",method = RequestMethod.POST)
    public ManagerProductInfo findProductById(Long id, Model model){
        return productInfoService.findProductById(id);
    }
}
