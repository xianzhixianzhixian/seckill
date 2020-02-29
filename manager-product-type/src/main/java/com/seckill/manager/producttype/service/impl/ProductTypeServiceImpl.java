package com.seckill.manager.producttype.service.impl;

import com.seckill.common.bean.ManagerProductType;
import com.seckill.manager.producttype.service.ProductTypeService;
import com.seckill.manager.producttype.mapper.ManagerProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ManagerProductTypeMapper productTypeMapper;

    @Override
    public Integer saveProductType(ManagerProductType productTypeInfo){
        return productTypeMapper.insert(productTypeInfo);
    }
}
