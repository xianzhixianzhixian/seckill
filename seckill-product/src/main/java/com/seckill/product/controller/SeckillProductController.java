package com.seckill.product.controller;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.product.service.SeckillProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("/listProductBy")
    public String listShopProduct(Long shopId, Model model) {
        List<ManagerProductInfo> productInfoList = seckillProductService.listProductByShopId(shopId);
        model.addAttribute("productInfoList", productInfoList);
        return "listproduct";
    }

    @PostMapping("/toPreSaveSeckill")
    public String saveSeckillProduct(Long productId, Model model) {
        ManagerProductInfo productInfo = seckillProductService.findProductByProductId(productId);
        model.addAttribute("productInfo", productInfo);
        return "preSaveSeckill";
    }
}
