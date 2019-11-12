package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillProductDetail;
import com.seckill.product.mapper.SeckillProductDetailMapper;
import com.seckill.product.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {


    @Autowired
    private SeckillProductDetailMapper productDetailMapper;

    @Override
    public Integer saveProductDetail(SeckillProductDetail productDetail){
        return productDetailMapper.insert(productDetail);
    }
}
