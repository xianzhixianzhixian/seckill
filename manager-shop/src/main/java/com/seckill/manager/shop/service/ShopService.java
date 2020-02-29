package com.seckill.manager.shop.service;

import com.seckill.common.bean.ManagerShop;

import java.util.List;

public interface ShopService {

    /**
     * 增加商店信息
     * @param shopInfo
     * @return
     */
    Integer addShopInfo(ManagerShop shopInfo);

    /**
     * 查找商店列表
     * @param shopInfo
     * @return
     */
    List<ManagerShop> listShopInfoBy(ManagerShop shopInfo);

    /**
     * 更新商店信息
     * @param shopInfo
     * @return
     */
    Integer updateShopInfoSelective(ManagerShop shopInfo);
}
