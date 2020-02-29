package com.seckill.product.service;

import com.seckill.common.bean.SeckillUserResult;

import java.util.List;

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

    /**
     * 悲观锁查询数据
     * @param id
     * @return
     */
    SeckillUserResult selectSeckillUserResultByIdForUpdate(Long id);

    /**
     * 根据用户id查询客户所有秒杀的结果
     * @param userId
     * @return
     */
    List<SeckillUserResult> selectSeckillUserResultByUserId(Long userId);
}
