package com.seckill.manager.shop.service.impl;

import com.seckill.common.bean.ManagerShop;
import com.seckill.common.bean.ManagerShopExample;
import com.seckill.manager.shop.mapper.ManagerShopMapper;
import com.seckill.manager.shop.service.ShopService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ManagerShopMapper managerShopMapper;

    @Override
    public Integer addShopInfo(ManagerShop shopInfo){
        shopInfo.setState(0);
        shopInfo.setCreateTime(new Date());
        return managerShopMapper.insert(shopInfo);
    }

    @Override
    public List<ManagerShop> listShopInfoBy(ManagerShop shopInfo){
        ManagerShopExample example = new ManagerShopExample();
        ManagerShopExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(shopInfo.getShopName())){
            //mybatis的通配符需要手动添加
            criteria.andShopNameLike(shopInfo.getShopName() + "%");
        }
        if(shopInfo.getState() != null){
            criteria.andStateEqualTo(shopInfo.getState());
        }
        return managerShopMapper.selectByExample(example);
    }

    @Override
    public Integer updateShopInfoSelective(ManagerShop shopInfo){
        ManagerShopExample example = new ManagerShopExample();
        ManagerShopExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(shopInfo.getId());
        return managerShopMapper.updateByExampleSelective(shopInfo, example);
    }
}
