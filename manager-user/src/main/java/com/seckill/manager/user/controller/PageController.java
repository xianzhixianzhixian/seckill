package com.seckill.manager.user.controller;

import com.seckill.common.bean.ManagerUser;
import com.seckill.common.request.SeckillCodeMapping;
import com.seckill.common.request.SeckillResult;
import com.seckill.manager.user.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xianzhixianzhixian on 2019/11/06
 */
@RestController
@RequestMapping("/user")
public class PageController {

    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/userPage")
    public SeckillResult userPage(Long id) {
        return new SeckillResult(userService.findUserById(id));
    }

    @PostMapping("/registerUser")
    public SeckillResult registerUser(@RequestBody ManagerUser userInfo) {
        if (StringUtils.isEmpty(userInfo.getAccount())) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "用户账户不能为空");
        }
        if (StringUtils.isEmpty(userInfo.getEncryptionPassword()) || StringUtils.isEmpty(userInfo.getOriginalPassword())) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "用户密码不能为空");
        }
        if (!userInfo.getEncryptionPassword().equals(userInfo.getOriginalPassword())) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "两次输入密码不一致");
        }
        return new SeckillResult(userService.addUser(userInfo));
    }

    @PostMapping("/loginUser")
    public SeckillResult loginUser(String account, String passwd) {
        if (StringUtils.isEmpty(account)) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "用户账户不能为空");
        }
        if (StringUtils.isEmpty(passwd)) {
            return new SeckillResult(SeckillCodeMapping.PARAMETER_ERROR, "密码不能为空");
        }
        try {
            Boolean result = userService.verifyAccount(account, passwd);
            if (!result) {
                return new SeckillResult(SeckillCodeMapping.BUSINESS_FAIL, "账户或密码错误");
            } else {
                return new SeckillResult("登录成功");
            }
        } catch (Exception e) {
            logger.error("用户登录错误，原因{}", e);
            return new SeckillResult(SeckillCodeMapping.SYSTEM_ERROR, "用户登录错误", e);
        }
    }
}
