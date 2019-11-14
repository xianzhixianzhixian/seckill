package com.seckill.manager.user.service;

import com.seckill.common.bean.ManagerUser;

public interface UserService {

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    ManagerUser findUserById(Long id);

    /**
     * 添加用户信息
     * @param userInfo
     * @return
     */
    Integer addUser(ManagerUser userInfo);

    /**
     * 根据账户号查找用户信息
     * @param account
     * @param passwd
     * @return
     */
    Boolean verifyAccount(String account, String passwd) throws Exception;
}
