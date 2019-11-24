package com.seckill.manager.user.controller;

import com.seckill.common.bean.ManagerUser;
import com.seckill.manager.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping(value = "/findUserById")
    public ManagerUser findUserById(Long id) {
        return userService.findUserById(id);
    }
}
