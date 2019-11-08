package com.seckill.shop.service.impl;

import com.seckill.common.bean.SeckillShop;
import com.seckill.shop.bean.SeckillShopExample;
import com.seckill.shop.mapper.SeckillShopMapper;
import com.seckill.shop.service.ShopService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private SeckillShopMapper seckillShopMapper;

    @Override
    public Integer addShopInfo(SeckillShop shopInfo){
        shopInfo.setState(0);
        shopInfo.setCreateTime(new Date());
        return seckillShopMapper.insert(shopInfo);
    }

    @Override
    public List<SeckillShop> listShopInfoBy(SeckillShop shopInfo){

        SeckillShopExample example = new SeckillShopExample();
        SeckillShopExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(shopInfo.getShopName())){
            criteria.andShopNameEqualTo(shopInfo.getShopName());
        }
        if(shopInfo.getState() != null){
            criteria.andStateEqualTo(shopInfo.getState());
        }
        return seckillShopMapper.selectByExample(example);
    }

    @Override
    public Integer updateShopInfoSelective(SeckillShop shopInfo){
        SeckillShopExample example = new SeckillShopExample();
        SeckillShopExample.Criteria criteria = example.createCriteria();
        criteria.andShopNameEqualTo(shopInfo.getShopName());
        return seckillShopMapper.updateByExampleSelective(shopInfo, example);
    }
}
