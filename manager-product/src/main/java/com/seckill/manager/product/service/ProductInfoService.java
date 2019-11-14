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
     * @param shopId
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
     * 根据id查找产品信息
     * @param id
     * @return
     */
    ManagerProductInfo findProductById(Long id);
}
