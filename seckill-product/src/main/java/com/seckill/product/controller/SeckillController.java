package com.seckill.product.controller;

import com.seckill.common.bean.SeckillResult;
import com.seckill.common.constant.SeckillReturnCodeMapping;
import com.seckill.product.service.impl.SeckillServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seckill")
public class SeckillController {

    private static final Logger logger = LoggerFactory.getLogger(SeckillController.class);

    @Autowired
    private SeckillServiceImpl seckillService;

    @ResponseBody
    @PostMapping("/seckillProductAOP")
    public SeckillResult seckillProductAOP(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        try {
            Integer seckillNum = seckillService.seckillProductAOP(userId, seckillProductId);
            if (seckillNum == 0) {
                return new SeckillResult(SeckillReturnCodeMapping.BUSINESS_FAIL, "商品已经卖完了哦！");
            } else {
                return new SeckillResult(SeckillReturnCodeMapping.SUCCESS_CODE, "抢购成功！");
            }
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, "系统错误", e);
        }
    }
    
    @PostMapping("/multipltThreadSeckillProduct")
    public void multipltThreadSeckillProduct(@RequestParam("userId") Long userId, @RequestParam("seckillProductId") Long seckillProductId) {
        seckillService.multipltThreadSeckillProduct(userId, seckillProductId);
    }
}
