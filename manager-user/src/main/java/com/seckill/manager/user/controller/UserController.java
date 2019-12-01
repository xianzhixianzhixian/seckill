package com.seckill.manager.user.controller;

import com.seckill.common.bean.SeckillResult;
import com.seckill.manager.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/findUserById")
    public SeckillResult findUserById(Long id) {
        return new SeckillResult(userService.findUserById(id));
    }
}
