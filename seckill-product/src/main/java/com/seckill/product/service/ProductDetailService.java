package com.seckill.product.service;

import com.seckill.common.bean.SeckillProductDetail;

public interface ProductDetailService {

    /**
     * 添加商品详情
     * @param productDetail
     * @return
     */
    Integer saveProductDetail(SeckillProductDetail productDetail);
}
