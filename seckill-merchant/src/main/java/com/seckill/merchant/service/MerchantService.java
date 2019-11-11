package com.seckill.merchant.service;

import com.seckill.common.bean.SeckillMerchant;

public interface MerchantService {

    /**
     * 根据商家id查询商家信息
     * @param id
     * @return
     */
    SeckillMerchant findMerchantByid(Long id);

    /**
     * 新增商家
     * @param merchantInfo
     * @return
     * @throws Exception
     */
    Integer addMerchantInfo(SeckillMerchant merchantInfo) throws Exception;

    /**
     * 登录商家
     * @param merchantInfo
     * @return
     * @throws Exception
     */
    Boolean verifyMerchantAccount(SeckillMerchant merchantInfo) throws Exception;
}
