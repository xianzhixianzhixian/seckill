package com.seckill.producttype.service.impl;

import com.seckill.common.bean.SeckillProductType;
import com.seckill.producttype.mapper.SeckillProductTypeMapper;
import com.seckill.producttype.service.ProductTypeService;
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
