package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillProductInfo;
import com.seckill.product.bean.SeckillProductInfoExample;
import com.seckill.product.mapper.SeckillProductInfoMapper;
import com.seckill.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductInfoServiceImpl implements ProductInfoService {


    @Autowired
    private SeckillProductInfoMapper productInfoMapper;

    @Override
    public Integer saveProductInfo(SeckillProductInfo productInfo) {
        productInfo.setCreateTime(new Date());
        productInfo.setState(0);
        return productInfoMapper.insert(productInfo);
    }

    @Override
    public List<SeckillProductInfo> listProductInfo(Long shopId){
        SeckillProductInfoExample example = new SeckillProductInfoExample();
        SeckillProductInfoExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId);
        criteria.andStateEqualTo(1);
        return productInfoMapper.selectByExample(example);
    }

    @Override
    public Integer updateProductInfo(SeckillProductInfo productInfo){
        productInfo.setUpdateTime(new Date());
        if(productInfo.getState() == 1 || productInfo.getState() == 2) {
            productInfo.setApproveTime(new Date());
        }
        return productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }

    @Override
    public SeckillProductInfo findProductById(Long id){
        return productInfoMapper.selectByPrimaryKey(id);
    }
}
