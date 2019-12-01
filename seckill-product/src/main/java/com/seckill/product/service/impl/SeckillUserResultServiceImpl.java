package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillUserResult;
import com.seckill.product.mapper.SeckillUserResultMapper;
import com.seckill.product.service.SeckillUserResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeckillUserResultServiceImpl implements SeckillUserResultService {

    @Autowired
    private SeckillUserResultMapper seckillUserResultMapper;

    @Override
    public Integer saveSeckillUserResult(SeckillUserResult seckillUserResult) {
        return seckillUserResultMapper.insert(seckillUserResult);
    }
}
