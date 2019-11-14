package com.seckill.manager.user.service.impl;

import com.seckill.common.utils.MD5Util;
import com.seckill.common.bean.ManagerUser;
import com.seckill.common.mapper.ManagerUserMapper;
import com.seckill.common.bean.ManagerUserExample;
import com.seckill.manager.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ManagerUserMapper managerUserMapper;

    @Override
    public ManagerUser findUserById(Long id) {
        return managerUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addUser(ManagerUser userInfo) {
        try {
            userInfo.setEncryptionPassword(MD5Util.md5(userInfo.getOriginalPassword(), MD5Util.MD5KEY));
        } catch (Throwable t) {

        }
        return managerUserMapper.insertSelective(userInfo);
    }

    @Override
    public Boolean verifyAccount(String account, String passwd) throws Exception {
        ManagerUserExample example = new ManagerUserExample();
        ManagerUserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        List<ManagerUser> ManagerUserList = managerUserMapper.selectByExample(example);
        ManagerUser ManagerUser = null;
        if (ManagerUserList != null && ManagerUserList.size() > 0) {
            ManagerUser = ManagerUserList.get(0);
        }
        if (ManagerUser != null) {
            return MD5Util.verify(passwd, MD5Util.MD5KEY, ManagerUser.getEncryptionPassword());
        }
        return false;
    }
}
