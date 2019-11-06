package com.seckill.user.controller;

import com.seckill.user.bean.SeckillUser;
import com.seckill.user.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面控制controller
 * @author xianzhixianzhixian on 2019/11/06
 */
@Controller
public class PageController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage(Long id, Model model) {
        SeckillUser seckillUser = userService.findUserById(id);
        model.addAttribute("userInfo", seckillUser);
        return "viewUser";
    }
}
