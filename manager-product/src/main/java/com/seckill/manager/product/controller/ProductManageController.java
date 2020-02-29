package com.seckill.manager.product.controller;

import com.seckill.common.bean.ManagerProductDetail;
import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.manager.product.service.impl.ProductInfoServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductManageController {

    private static final Logger logger = LoggerFactory.getLogger(ProductManageController.class);

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @PostMapping("/listProduct")
    public List<ManagerProductInfo> listProduct(Long shopId, Integer state) {
        return productInfoService.listProductInfo(shopId, state);
    }

    @PostMapping("/updateState")
    public Integer updateState(Long id, Integer state) {
        ManagerProductInfo productInfo = new ManagerProductInfo();
        productInfo.setId(id);
        productInfo.setState(state);
        return productInfoService.updateProductInfo(productInfo);
    }

    @PostMapping("/addProductDetail")
    public Integer addProductDetail(@RequestBody ManagerProductDetail productDetail) {
        return productInfoService.addProductDetail(productDetail);
    }

    @PostMapping("/findProductDetailByProductId")
    public ManagerProductDetail findProductDetailByProductId(Long productId) {
        return productInfoService.findProductDetailByProductId(productId);
    }
}
