package com.seckill.manager.merchant.controller;

import com.seckill.common.bean.ManagerMerchant;
import com.seckill.common.constant.SeckillReturnCodeType;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.utils.MD5Util;
import com.seckill.manager.merchant.service.impl.MerchantServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

    private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);

    @Autowired
    private MerchantServiceImpl merchantService;

    @PostMapping("/findMerchantbyId")
    public SeckillResult findMerchantbyId(Long id) {
        return new SeckillResult(merchantService.findMerchantByid(id));
    }

    @PostMapping("/checkIn")
    public SeckillResult registerUser(@RequestBody ManagerMerchant merchantInfo) {
        Integer result = 0;
        try {
            result = merchantService.addMerchantInfo(merchantInfo);
        } catch (Exception e) {
            logger.error("checkIn错误，原因{}", e);
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "商户入驻失败", e);
        }
        return new SeckillResult(result);
    }

    @PostMapping("/login")
    public SeckillResult login(@RequestBody ManagerMerchant merchantInfo) {
        if (StringUtils.isEmpty(merchantInfo.getAccount())){
            return new SeckillResult(SeckillReturnCodeType.PARAMETER_ERROR, "商家用户名不能为空");
        }
        if (StringUtils.isEmpty(merchantInfo.getOriginalPassword())) {
            return new SeckillResult(SeckillReturnCodeType.PARAMETER_ERROR, "密码不能为空");
        }
        try {
            ManagerMerchant merchant = merchantService.verifyMerchantAccount(merchantInfo);
            if (merchant != null) {
                Boolean result = MD5Util.verify(merchantInfo.getOriginalPassword(), MD5Util.MD5KEY, merchant.getEncryptionPassword());
                if (!result) {
                    return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "用户名或者密码不对");
                }
            } else {
                return new SeckillResult(SeckillReturnCodeType.BUSINESS_FAIL, "用户名或者密码不对");
            }
        } catch (Exception e) {
            logger.error("登录错误，原因{}", e);
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "登录错误", e);
        }
        return new SeckillResult(merchantInfo);
    }

}
