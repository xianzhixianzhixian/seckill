package com.seckill.user.service;

import com.seckill.user.bean.SeckillUser;

import java.util.List;

public interface UserService {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    SeckillUser findUserById(Long id);
}
