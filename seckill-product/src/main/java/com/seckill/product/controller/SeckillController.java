package com.seckill.product.controller;

import com.seckill.common.request.SeckillResult;
import com.seckill.common.request.SeckillReturnCodeMapping;
import com.seckill.product.service.impl.SeckillServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seckill")
public class SeckillController {

    private static final Logger logger = LoggerFactory.getLogger(SeckillController.class);

    @Autowired
    private SeckillServiceImpl seckillService;

    @PostMapping("/buySeckillProduct")
    public SeckillResult buySeckillProduct(@RequestParam Long userId, @RequestParam Long id) {
        try {
            return new SeckillResult(seckillService.buySeckillProduct(userId, id));
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeMapping.SYSTEM_ERROR, "系统错误", e);
        }
    }
}
