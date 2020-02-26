package com.seckill.product.service.impl;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillProductExample;
import com.seckill.product.mapper.SeckillProductMapper;
import com.seckill.product.service.SeckillProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillProductServiceImpl implements SeckillProductService {

    @Autowired
    private SeckillProductMapper seckillProductMapper;

    @Override
    public SeckillProduct findSeckillProductBySeckillProductId(Long seckillProductId) {
        return seckillProductMapper.selectByPrimaryKey(seckillProductId);
    }

    @Override
    public Integer saveSeckillProfduct(SeckillProduct seckillProduct) {
        seckillProduct.setSeckillVersion(0);
        return seckillProductMapper.insert(seckillProduct);
    }

    @Override
    public List<SeckillProduct> listSeckillProduct(Long shopId, Integer state) {
        SeckillProductExample example = new SeckillProductExample();
        SeckillProductExample.Criteria criteria = example.createCriteria();
        if (shopId != null) {
            criteria.andShopIdEqualTo(shopId);
        }
        if (state != null) {
            criteria.andStateEqualTo(state);
        }
        return seckillProductMapper.selectByExample(example);
    }

    @Override
    public Integer updateSeckillProductByPrimaryKeySelective(SeckillProduct seckillProduct) {
        return seckillProductMapper.updateByPrimaryKeySelective(seckillProduct);
    }

    @Override
    public Integer updateSeckillProductByExampleSelective(SeckillProduct seckillProduct, SeckillProductExample example) {
        return seckillProductMapper.updateByExampleSelective(seckillProduct, example);
    }

    @Override
    public SeckillProduct findSeckillProductById(Long id) {
        return seckillProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public SeckillProduct findSeckillProductByIdForUpdate(Long seckillProductId) {
        return seckillProductMapper.selectByPrimaryKeyForUpdate(seckillProductId);
    }
}
