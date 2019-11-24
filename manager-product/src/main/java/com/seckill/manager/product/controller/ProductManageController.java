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

    @GetMapping("/listProduct")
    public String listProduct(Long shopId, Integer state, Model model) {
        try {
            List<ManagerProductInfo> list = productInfoService.listProductInfo(shopId, state);
            model.addAttribute("productList", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listproduct";
    }

    @GetMapping(value = "/updateState")
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
