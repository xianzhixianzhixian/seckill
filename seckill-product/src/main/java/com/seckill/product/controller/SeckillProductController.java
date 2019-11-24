package com.seckill.product.controller;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.product.service.SeckillProductFeignService;
import com.seckill.product.service.impl.SeckillProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 商品秒杀服务controller
 */
@RequestMapping("/seckillProduct")
@Controller
public class SeckillProductController {

    @Autowired
    private SeckillProductFeignService seckillProductFeignService;
    @Autowired
    private SeckillProductServiceImpl seckillProductService;

    @PostMapping("/listProductByShopId")
    public List<ManagerProductInfo> listProductByShopId(Long shopId) {
        return seckillProductFeignService.listProductByShopId(shopId);
    }

    @PostMapping("/listProductBy")
    public String listShopProduct(Long shopId, Model model) {
        List<ManagerProductInfo> productInfoList = seckillProductFeignService.listProductByShopId(shopId);
        model.addAttribute("productInfoList", productInfoList);
        return "listproduct";
    }

    @PostMapping("/preSaveSeckillProduct")
    public String saveSeckillProduct(Long productId, Model model) {
        ManagerProductInfo productInfo = seckillProductFeignService.findProductByProductId(productId);
        model.addAttribute("productInfo", productInfo);
        return "preSaveSeckill";
    }

    @PostMapping("/saveSeckillProduct")
    public Integer saveSeckillProfduct(SeckillProduct seckillProduct) {
        return seckillProductService.saveSeckillProfduct(seckillProduct);
    }

    @GetMapping("/listAllSeckillProduct")
    public String listAllSeckillProduct(Long shopId, Model model) {
        //查询商店申请中的商品
        List<SeckillProduct> seckillProductList = seckillProductService.listSeckillProduct(shopId, 0);
        model.addAttribute("seckillProductList", seckillProductList);
        return "listSeckillProductInfo";
    }

    @GetMapping("/updateSeckillProductInfo")
    public String updateSeckillProductInfo(Long id, Integer state) {
        SeckillProduct seckillProduct = new SeckillProduct();
        seckillProduct.setId(id);
        seckillProduct.setState(state);
        seckillProduct.setApproveTime(new Date());
        seckillProductService.updateSeckillProductInfo(seckillProduct);
        return "seckillUpdateSuccess";
    }

    @GetMapping("/listAllSeckillProductByState")
    public String listAllSeckillProductByState(Long shopId, Integer state, Model model) {
        List<SeckillProduct> seckillProductList = seckillProductService.listSeckillProduct(shopId, state);
        model.addAttribute("seckillProductList", seckillProductList);
        return "seckillPortal";
    }
}
