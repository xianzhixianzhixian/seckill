package com.seckill.manager.merchant.service;

import com.seckill.common.bean.ManagerMerchant;

public interface MerchantService {

    /**
     * 根据商家id查询商家信息
     * @param id
     * @return
     */
    ManagerMerchant findMerchantByid(Long id);

    /**
     * 新增商家
     * @param merchantInfo
     * @return
     * @throws Exception
     */
    Integer addMerchantInfo(ManagerMerchant merchantInfo) throws Exception;

    /**
     * 登录商家
     * @param merchantInfo
     * @return
     * @throws Exception
     */
    Boolean verifyMerchantAccount(ManagerMerchant merchantInfo) throws Exception;
}
