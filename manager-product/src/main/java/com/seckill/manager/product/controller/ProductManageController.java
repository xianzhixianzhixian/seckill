package com.seckill.manager.product.controller;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.manager.product.service.impl.ProductInfoServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductManageController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @GetMapping(value = "/toApplyProduct")
    public String toApplyProduct() {
        return "toApplyProduct";
    }


    @PostMapping(value = "/applyProduct")
    public String applyProduct(ManagerProductInfo productInfo, Model model) {
        if (StringUtils.isBlank(productInfo.getProductName())) {
            model.addAttribute("error","商品名称不能为空");
            return "toRegisterUser";
        }
        if (StringUtils.isBlank(productInfo.getProductTitle())) {
            model.addAttribute("error","商品标题不能为空");
            return "toRegisterUser";
        }
        if (productInfo.getProductPrice() == null) {
            model.addAttribute("error","商品价格不能为空");
            return "toRegisterUser";
        }
        try {
            productInfoService.saveProductInfo(productInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "viewUser";
    }


    @GetMapping(value = "/listProduct")
    public String listProduct(Model model) {
        try {
            List<ManagerProductInfo> list = productInfoService.listProductInfo(-1L);
            model.addAttribute("productList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listproduct";
    }

    @PostMapping(value = "/updateState")
    public String updateState(Long id, Integer state) {
        try {
            ManagerProductInfo productInfo = new ManagerProductInfo();
            productInfo.setId(id);
            productInfo.setState(state);
            productInfoService.updateProductInfo(productInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listproduct";
    }
}
