package com.seckill.manager.product.service.impl;

import com.seckill.common.bean.ManagerProductDetail;
import com.seckill.common.bean.ManagerProductDetailExample;
import com.seckill.common.bean.ManagerProductInfo;
import com.seckill.manager.product.mapper.ManagerProductDetailMapper;
import com.seckill.manager.product.mapper.ManagerProductInfoMapper;
import com.seckill.common.bean.ManagerProductInfoExample;
import com.seckill.manager.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@CacheConfig(cacheNames = "productInfoCache")
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ManagerProductInfoMapper productInfoMapper;
    @Autowired
    private ManagerProductDetailMapper productDetailMapper;

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

    //把key的值定义为productInfo中id的值
    @CachePut(cacheNames = "productInfoCache", key = "#productInfo.id")
    @Override
    public Integer updateProductInfo(ManagerProductInfo productInfo){
        productInfo.setUpdateTime(new Date());
        if(productInfo.getState() == 1 || productInfo.getState() == 2) {
            productInfo.setApproveTime(new Date());
        }
        return productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }

    //把key的值定义为productId的值
    @Cacheable(cacheNames = "productInfoCache", key = "#productId")
    @Override
    public ManagerProductInfo findProductByProductId(Long productId){
        return productInfoMapper.selectByPrimaryKey(productId);
    }

    @Override
    public Integer addProductDetail(ManagerProductDetail productDetail) {
        return productDetailMapper.insert(productDetail);
    }

    /**
     * selectByExample不会返回null
     * @param productId
     * @return
     */
    @Override
    public ManagerProductDetail findProductDetailByProductId(Long productId) {
        ManagerProductDetailExample example = new ManagerProductDetailExample();
        ManagerProductDetailExample.Criteria criteria = example.createCriteria();
        criteria.andProductIdEqualTo(productId);
        List<ManagerProductDetail> productDetailList = productDetailMapper.selectByExample(example);
        if (productDetailList.size() == 0) {
            return null;
        } else {
            return productDetailList.get(0);
        }
    }
    
}
