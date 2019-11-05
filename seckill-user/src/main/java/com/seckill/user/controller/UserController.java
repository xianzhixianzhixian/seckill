package com.seckill.user.controller;

import com.seckill.user.bean.SeckillUser;
import com.seckill.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/findUserById")
    public SeckillUser findUserById(Long id) {
        return userService.findUserById(id);
    }
}
