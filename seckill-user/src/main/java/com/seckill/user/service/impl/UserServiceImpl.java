package com.seckill.user.service.impl;

import com.seckill.common.utils.MD5Util;
import com.seckill.user.bean.SeckillUser;
import com.seckill.user.bean.SeckillUserExample;
import com.seckill.user.mapper.SeckillUserMapper;
import com.seckill.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SeckillUserMapper seckillUserMapper;

    @Override
    public SeckillUser findUserById(Long id) {
        return seckillUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addUser(SeckillUser userInfo) {
        try {
            userInfo.setEncryptionPassword(MD5Util.md5(userInfo.getOriginalPassword(), MD5Util.MD5KEY));
        } catch (Throwable t) {

        }
        return seckillUserMapper.insertSelective(userInfo);
    }

    @Override
    public Boolean verifyAccount(String account, String passwd) throws Exception {
        SeckillUserExample example = new SeckillUserExample();
        SeckillUserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        List<SeckillUser> seckillUserList = seckillUserMapper.selectByExample(example);
        SeckillUser seckillUser = null;
        if (seckillUserList != null && seckillUserList.size() > 0) {
            seckillUser = seckillUserList.get(0);
        }
        if (seckillUser != null) {
            return MD5Util.verify(passwd, MD5Util.MD5KEY, seckillUser.getEncryptionPassword());
        }
        return false;
    }
}
