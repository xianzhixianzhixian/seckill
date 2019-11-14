package com.seckill.manager.user.controller;

import com.seckill.common.bean.ManagerUser;
import com.seckill.manager.user.service.impl.UserServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面控制controller
 * @author xianzhixianzhixian on 2019/11/06
 */
@RequestMapping("/user")
@Controller
public class PageController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/userPage", method = RequestMethod.GET)
    public String userPage(Long id, Model model) {
        ManagerUser ManagerUser = userService.findUserById(id);
        model.addAttribute("userInfo", ManagerUser);
        return "viewUser";
    }

    @RequestMapping(value = "/toRegisterUser", method = RequestMethod.GET)
    public String toRegisterUser() {
        return "toRegisterUser";
    }

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "toLogin";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(ManagerUser userInfo, Model model) {
        if (StringUtils.isBlank(userInfo.getAccount())) {
            model.addAttribute("error", "用户账户不能为空");
            return "toRegisterUser";
        }
        if (StringUtils.isBlank(userInfo.getEncryptionPassword()) || StringUtils.isBlank(userInfo.getOriginalPassword())) {
            model.addAttribute("error", "用户密码不能为空");
            return "toRegisterUser";
        }
        if (!userInfo.getEncryptionPassword().equals(userInfo.getOriginalPassword())) {
            model.addAttribute("error", "两次输入密码不一致");
            return "toRegisterUser";
        }
        userService.addUser(userInfo);
        return "toRegisterUser";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String loginUser(String account, String passwd, Model model) {
        if (StringUtils.isBlank(account)) {
            model.addAttribute("error", "用户账户不能为空");
            return "toLogin";
        }
        if (StringUtils.isBlank(passwd)) {
            model.addAttribute("error", "密码不能为空");
            return "toLogin";
        }
        try {
            Boolean result = userService.verifyAccount(account, passwd);
            if (!result) {
                model.addAttribute("error", "账户或密码错误");
            } else {
                model.addAttribute("error", "登录成功");
            }
        } catch (Throwable t) {

        }
        return "toLogin";
    }
}
