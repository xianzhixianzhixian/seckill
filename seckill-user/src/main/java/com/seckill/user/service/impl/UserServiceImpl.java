package com.seckill.user.service.impl;

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
}
