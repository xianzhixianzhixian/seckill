package com.seckill.product.service;

import com.seckill.common.bean.SeckillProduct;

import java.util.List;

/**
 * @author xianzhixianzhixian
 * @date 201911
 */
public interface SeckillProductService {

    /**
     * 保存秒杀商品
     * @param seckillProduct
     * @return
     */
    Integer saveSeckillProfduct(SeckillProduct seckillProduct);

    /**
     * 列出秒杀商品信息
     * @param shopId
     * @param state
     * @return
     */
    List<SeckillProduct> listSeckillProduct(Long shopId, Integer state);

    /**
     * 更新秒杀商品信息
     * @param seckillProduct
     * @return
     */
    Integer updateSeckillProductInfoSelective(SeckillProduct seckillProduct);

    /**
     * 根据id查找秒杀商品信息
     * @param id
     * @return
     */
    SeckillProduct findSeckillProductById(Long id);
}
