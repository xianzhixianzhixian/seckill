package com.seckill.product.controller;

import com.seckill.common.bean.ManagerMerchant;
import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.product.service.SeckillProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 商品秒杀服务controller
 */
@RequestMapping("/seckillProduct")
@Controller
public class SeckillProductController {

    @Autowired
    private SeckillProductService seckillProductService;

    @ResponseBody
    @PostMapping("/listProductByShopId")
    public List<ManagerProductInfo> listProductByShopId(Long shopId) {
        return seckillProductService.listProductByShopId(shopId);
    }

    @RequestMapping("/listProductBy")
    public String listShopProduct(Long shopId, Model model) {
        List<ManagerProductInfo> productInfoList = seckillProductService.listProductByShopId(shopId);
        model.addAttribute("productInfoList", productInfoList);
        return "listproduct";
    }
}
