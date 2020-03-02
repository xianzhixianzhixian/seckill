package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.bean.SeckillUserResultExample;
import com.seckill.product.mapper.SeckillUserResultMapper;
import com.seckill.product.service.SeckillUserResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillUserResultServiceImpl implements SeckillUserResultService {

    @Autowired
    private SeckillUserResultMapper seckillUserResultMapper;

    @Override
    public Integer saveSeckillUserResult(SeckillUserResult seckillUserResult) {
        return seckillUserResultMapper.insert(seckillUserResult);
    }

    @Override
    public SeckillUserResult selectSeckillUserResultByIdForUpdate(Long id) {
        return seckillUserResultMapper.selectByPrimaryKeyForUpdate(id);
    }

    @Override
    public List<SeckillUserResult> selectSeckillUserResultByUserId(Long userId) {
        SeckillUserResultExample example = new SeckillUserResultExample();
        SeckillUserResultExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<SeckillUserResult> seckillUserResultList = seckillUserResultMapper.selectByExample(example);
        return seckillUserResultList;
    }

    @Override
    public Integer updateSeckillUserResultByIdSelective(SeckillUserResult seckillUserResult) {
        return seckillUserResultMapper.updateByPrimaryKeySelective(seckillUserResult);
    }


}
