package com.seckill.product.controller;

import com.seckill.common.bean.SeckillProductInfo;
import com.seckill.product.service.impl.ProductDetailServiceImpl;
import com.seckill.product.service.impl.ProductInfoServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Autowired
    private ProductDetailServiceImpl productDetailService;

    @RequestMapping(value = "/toApplyProduct",method = RequestMethod.GET)
    public String toApplyProduct() {
        return "toApplyProduct";
    }


    @RequestMapping(value = "/applyProduct",method = RequestMethod.POST)
    public String applyProduct(SeckillProductInfo productInfo, Model model){
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


    @RequestMapping(value = "/listProduct",method = RequestMethod.GET)
    public String listProduct(Model model) {
        try {
            List<SeckillProductInfo> list = productInfoService.listProductInfo(-1L);
            model.addAttribute("list", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listproduct";
    }

    @RequestMapping(value = "/updateState",method = RequestMethod.GET)
    public String updateState(Long id ,Integer state,Model model) {
        try {
            SeckillProductInfo productInfo = new SeckillProductInfo();
            productInfo.setId(id);
            productInfo.setState(state);
            productInfoService.updateProductInfo(productInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "listproduct";
    }
}
