package com.seckill.product.service;

import com.seckill.common.bean.SeckillProductInfo;

import java.util.List;

public interface ProductInfoService {

    /**
     * 新增商品信息
     * @param productInfo
     * @return
     */
    Integer saveProductInfo(SeckillProductInfo productInfo);

    /**
     * 查询商店商品信息
     * @param shopId
     * @return
     */
    List<SeckillProductInfo> listProductInfo(Long shopId);

    /**
     * 更新产品信息
     * @param productInfo
     * @return
     */
    Integer updateProductInfo(SeckillProductInfo productInfo);

    /**
     * 根据id查找产品信息
     * @param id
     * @return
     */
    SeckillProductInfo findProductById(Long id);
}
