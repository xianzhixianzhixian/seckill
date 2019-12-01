package com.seckill.product.service;

import com.seckill.common.bean.SeckillUserResult;

/**
 * 用户秒杀结果Service
 */
public interface SeckillUserResultService {

    /**
     * 存储用户秒杀结果
     * @param seckillUserResult
     * @return
     */
    Integer saveSeckillUserResult(SeckillUserResult seckillUserResult);
}
