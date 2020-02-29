package com.seckill.manager.merchant.service.impl;

import com.seckill.common.bean.ManagerMerchant;
import com.seckill.common.bean.ManagerMerchantExample;
import com.seckill.manager.merchant.mapper.ManagerMerchantMapper;
import com.seckill.common.utils.MD5Util;
import com.seckill.manager.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private ManagerMerchantMapper merchantMapper;

    @Override
    public ManagerMerchant findMerchantByid(Long id){
        return merchantMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addMerchantInfo(ManagerMerchant merchantInfo) throws Exception {
        merchantInfo.setCreatetime(new Date());
        merchantInfo.setEncryptionPassword(MD5Util.md5(merchantInfo.getOriginalPassword(), MD5Util.MD5KEY));
        return merchantMapper.insert(merchantInfo);
    }

    @Override
    public ManagerMerchant verifyMerchantAccount(ManagerMerchant merchantInfo) throws Exception {
        String account = merchantInfo.getAccount();
        String password = merchantInfo.getOriginalPassword();
        ManagerMerchantExample example = new ManagerMerchantExample();
        ManagerMerchantExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        List<ManagerMerchant> merchantInfoList = merchantMapper.selectByExample(example);
        if(merchantInfoList == null || merchantInfoList.size() == 0) {
            return null;
        }
        ManagerMerchant merchantInfoSearch = merchantInfoList.get(0);
        return merchantInfoSearch;
    }
}
