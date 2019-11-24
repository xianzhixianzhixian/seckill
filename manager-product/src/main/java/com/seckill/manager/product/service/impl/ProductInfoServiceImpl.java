package com.seckill.manager.product.service.impl;

import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.manager.product.mapper.ManagerProductInfoMapper;
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
    public List<ManagerProductInfo> listProductInfo(Long shopId, Integer state){
        ManagerProductInfoExample example = new ManagerProductInfoExample();
        ManagerProductInfoExample.Criteria criteria = example.createCriteria();
        if (shopId != null && shopId != -1) {
            criteria.andShopIdEqualTo(shopId);
        }
        if (state != null && state != -1) {
            criteria.andStateEqualTo(state);
        }
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
    public ManagerProductInfo findProductByProductId(Long productId){
        return productInfoMapper.selectByPrimaryKey(productId);
    }
}
