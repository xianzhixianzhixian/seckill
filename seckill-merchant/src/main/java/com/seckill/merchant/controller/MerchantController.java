package com.seckill.merchant.controller;

import com.seckill.common.bean.SeckillMerchant;
import com.seckill.merchant.service.impl.MerchantServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantServiceImpl merchantService;

    @RequestMapping(value = "/findMerchantbyId", method = RequestMethod.GET)
    public String findMerchantbyId(Long id, Model model) {
        SeckillMerchant merchantInfo = merchantService.findMerchantByid(id);
        model.addAttribute("merchantInfo", merchantInfo);
        return "viewMerchant";
    }

    @RequestMapping(value = "/toCheckIn", method = RequestMethod.GET)
    public String toCheckIn() {
        return "toCheckIn";
    }

    @RequestMapping(value = "/checkIn", method = RequestMethod.POST)
    public String registerUser(SeckillMerchant merchantInfo, Model model) {
        if (StringUtils.isBlank(merchantInfo.getAccount())) {
            model.addAttribute("error", "商家账号不能为空");
            return "toCheckIn";
        }
        if (StringUtils.isBlank(merchantInfo.getOriginalPassword()) || StringUtils.isBlank(merchantInfo.getEncryptionPassword())) {
            model.addAttribute("error", "密码不能为空");
            return "toCheckIn";
        }
        if (!merchantInfo.getOriginalPassword().equals(merchantInfo.getEncryptionPassword())) {
            model.addAttribute("error", "两次密码输入不一致");
            return "toCheckIn";
        }
        try {
            merchantService.addMerchantInfo(merchantInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "viewMerchant";
    }

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "toLogin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(SeckillMerchant merchantInfo, Model model) {
        if (StringUtils.isBlank(merchantInfo.getAccount())){
            model.addAttribute("error","商家用户名不能为空");
            return "toLogin";
        }
        if (StringUtils.isBlank(merchantInfo.getOriginalPassword())) {
            model.addAttribute("error","密码不能为空");
            return "toLogin";
        }
        try {
            Boolean result = merchantService.verifyMerchantAccount(merchantInfo);
            if (!result) {
                model.addAttribute("error","用户名或者密码不对");
                return "toLogin";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "viewMerchant";
    }

}
