package com.seckill.manager.product.service.impl;

import com.seckill.common.bean.ManagerProductDetail;
import com.seckill.manager.product.mapper.ManagerProductDetailMapper;
import com.seckill.manager.product.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {


    @Autowired
    private ManagerProductDetailMapper productDetailMapper;

    @Override
    public Integer saveProductDetail(ManagerProductDetail productDetail){
        return productDetailMapper.insert(productDetail);
    }
}
