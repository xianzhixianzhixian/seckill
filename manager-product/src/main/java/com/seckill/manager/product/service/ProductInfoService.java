package com.seckill.manager.product.service;

import com.seckill.common.bean.ManagerProductInfo;

import java.util.List;

public interface ProductInfoService {

    /**
     * 新增商品信息
     * @param productInfo
     * @return
     */
    Integer saveProductInfo(ManagerProductInfo productInfo);

    /**
     * 查询商店商品信息
     * @param shopId 值为-1的时候查询所有商品
     * @return
     */
    List<ManagerProductInfo> listProductInfo(Long shopId);

    /**
     * 更新产品信息
     * @param productInfo
     * @return
     */
    Integer updateProductInfo(ManagerProductInfo productInfo);

    /**
     * 根据产品id查找产品信息
     * @param productId
     * @return
     */
    ManagerProductInfo findProductByProductId(Long productId);
}
