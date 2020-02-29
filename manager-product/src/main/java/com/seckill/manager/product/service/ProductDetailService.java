package com.seckill.manager.product.service;

import com.seckill.common.bean.ManagerProductDetail;

public interface ProductDetailService {

    /**
     * 添加商品详情
     * @param productDetail
     * @return
     */
    Integer saveProductDetail(ManagerProductDetail productDetail);
}
