package com.seckill.product.service.impl;

import com.seckill.product.service.SeckillProductStrategyService;
import com.seckill.product.util.RedissonLockUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillProductStrategyServiceImpl implements SeckillProductStrategyService {

    @Autowired
    private RedissonLockUtil redissonLockUtil;

    @Override
    public String setSeckillProductStrategy(String strategyName, String strategyValue) {
        return redissonLockUtil.addToBucket(strategyName, strategyValue);
    }
}
