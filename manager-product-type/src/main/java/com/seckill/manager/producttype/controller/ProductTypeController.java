package com.seckill.manager.producttype.controller;

import com.seckill.common.bean.ManagerProductType;
import com.seckill.manager.producttype.service.impl.ProductTypeServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @RequestMapping(value = "/toAddProductTypeInfo",method = RequestMethod.GET)
    public String toAddProductTypeInfo(){
        return "toAddProductTypeInfo";
    }


    @RequestMapping(value = "/addProductTypeInfo", method = RequestMethod.POST)
    public String addProductTypeInfo(ManagerProductType productTypeInfo, Model model){
        if(StringUtils.isBlank(productTypeInfo.getProductTypeName())){
            model.addAttribute("error","商品类别名称不能为空");
            return "toAddProductTypeInfo";
        }
        try {
            productTypeService.saveProductType(productTypeInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "AddProductTypeInfoSuccess";
    }





}
