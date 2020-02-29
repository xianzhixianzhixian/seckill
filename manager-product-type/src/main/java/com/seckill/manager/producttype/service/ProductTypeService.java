package com.seckill.manager.producttype.service;

import com.seckill.common.bean.ManagerProductType;

public interface ProductTypeService {

    /**
     * 添加商品分类信息
     * @param productTypeInfo
     * @return
     */
    Integer saveProductType(ManagerProductType productTypeInfo);
}
