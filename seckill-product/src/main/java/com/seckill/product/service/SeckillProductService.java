package com.seckill.product.service;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillProductExample;

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
     * 根据主键更新秒杀商品信息
     * @param seckillProduct
     * @return
     */
    Integer updateSeckillProductByPrimaryKeySelective(SeckillProduct seckillProduct);

    /**
     * 根据example更新秒杀商品信息
     * @param seckillProduct
     * @return
     */
    Integer updateSeckillProductByExampleSelective(SeckillProduct seckillProduct, SeckillProductExample example);

    /**
     * 根据id查找秒杀商品信息
     * @param seckillProductId
     * @return
     */
    SeckillProduct findSeckillProductById(Long seckillProductId);

    /**
     * 根据id查找秒杀商品信息
     * @param seckillProductId
     * @return
     */
    SeckillProduct findSeckillProductByIdForUpdate(Long seckillProductId);
}
