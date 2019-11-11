package com.seckill.merchant.service.impl;

import com.seckill.common.bean.SeckillProductType;
import com.seckill.merchant.mapper.SeckillProductTypeMapper;
import com.seckill.merchant.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private SeckillProductTypeMapper productTypeMapper;

    @Override
    public Integer saveProductType(SeckillProductType productTypeInfo){
        return productTypeMapper.insert(productTypeInfo);
    }
}
