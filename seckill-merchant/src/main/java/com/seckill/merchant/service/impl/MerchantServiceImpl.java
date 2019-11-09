package com.seckill.merchant.service.impl;

import com.seckill.common.bean.SeckillMerchant;
import com.seckill.common.utils.MD5Util;
import com.seckill.merchant.bean.SeckillMerchantExample;
import com.seckill.merchant.mapper.SeckillMerchantMapper;
import com.seckill.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private SeckillMerchantMapper merchantMapper;

    @Override
    public SeckillMerchant findMerchantByid(Long id){
        return merchantMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addMerchantInfo(SeckillMerchant merchantInfo) throws Exception {
        merchantInfo.setCreatetime(new Date());
        merchantInfo.setEncryptionPassword(MD5Util.md5(merchantInfo.getOriginalPassword(), MD5Util.MD5KEY));
        return merchantMapper.insert(merchantInfo);
    }

    @Override
    public Boolean verifyMerchantAccount(SeckillMerchant merchantInfo) throws Exception {
        String account = merchantInfo.getAccount();
        String password = merchantInfo.getOriginalPassword();
        SeckillMerchantExample example = new SeckillMerchantExample();
        SeckillMerchantExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        List<SeckillMerchant> merchantInfoList = merchantMapper.selectByExample(example);
        if(merchantInfoList == null || merchantInfoList.size() == 0) {
            return false;
        }
        SeckillMerchant merchantInfoSearch = merchantInfoList.get(0);
        String encryptionPassword = merchantInfoSearch.getEncryptionPassword();
        return MD5Util.verify(password, MD5Util.MD5KEY, encryptionPassword);
    }
}
