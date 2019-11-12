package com.seckill.producttype.service;

import com.seckill.common.bean.SeckillProductType;

public interface ProductTypeService {

    /**
     * 添加商品分类信息
     * @param productTypeInfo
     * @return
     */
    Integer saveProductType(SeckillProductType productTypeInfo);
}
