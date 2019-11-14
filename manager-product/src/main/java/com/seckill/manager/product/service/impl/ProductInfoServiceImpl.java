package com.seckill.manager.product.service.impl;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.common.mapper.ManagerProductInfoMapper;
import com.seckill.common.bean.ManagerProductInfoExample;
import com.seckill.manager.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {


    @Autowired
    private ManagerProductInfoMapper productInfoMapper;

    @Override
    public Integer saveProductInfo(ManagerProductInfo productInfo) {
        productInfo.setCreateTime(new Date());
        productInfo.setState(0);
        return productInfoMapper.insert(productInfo);
    }

    @Override
    public List<ManagerProductInfo> listProductInfo(Long shopId){
        ManagerProductInfoExample example = new ManagerProductInfoExample();
        ManagerProductInfoExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andStateEqualTo(1);
        return productInfoMapper.selectByExample(example);
    }

    @Override
    public Integer updateProductInfo(ManagerProductInfo productInfo){
        productInfo.setUpdateTime(new Date());
        if(productInfo.getState() == 1 || productInfo.getState() == 2) {
            productInfo.setApproveTime(new Date());
        }
        return productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }

    @Override
    public ManagerProductInfo findProductById(Long id){
        return productInfoMapper.selectByPrimaryKey(id);
    }
}
