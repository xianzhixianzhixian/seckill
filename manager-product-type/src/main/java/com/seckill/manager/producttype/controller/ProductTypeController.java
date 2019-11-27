package com.seckill.manager.producttype.controller;

import com.seckill.common.bean.ManagerProductType;
import com.seckill.common.request.SeckillReturnCodeMapping;
import com.seckill.common.request.SeckillResult;
import com.seckill.manager.producttype.service.impl.ProductTypeServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    private static final Logger logger = LoggerFactory.getLogger(ProductTypeController.class);

    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @PostMapping("/addProductTypeInfo")
    public SeckillResult addProductTypeInfo(@RequestBody ManagerProductType productTypeInfo){

        if(StringUtils.isEmpty(productTypeInfo.getProductTypeName())) {
            return new SeckillResult(SeckillReturnCodeMapping.PARAMETER_ERROR, "商品类别名称不能为空");
        }
        try {
            return new SeckillResult(productTypeService.saveProductType(productTypeInfo));
        } catch (Exception e) {
            logger.error("添加商品分类信息错误，原因{}", e);
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, "添加商品分类信息错误", e);
        }
    }

}
