package com.seckill.shop.service;

import com.seckill.common.bean.SeckillShop;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShopService {

    /**
     * 增加商店信息
     * @param shopInfo
     * @return
     */
    Integer addShopInfo(SeckillShop shopInfo);

    /**
     * 查找商店列表
     * @param shopInfo
     * @return
     */
    List<SeckillShop> listShopInfoBy(SeckillShop shopInfo);

    /**
     * 更新商店信息
     * @param shopInfo
     * @return
     */
    Integer updateShopInfoSelective(SeckillShop shopInfo);
}
