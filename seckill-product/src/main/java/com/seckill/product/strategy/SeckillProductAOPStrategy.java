package com.seckill.product.strategy;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.product.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SeckillProductAOPStrategy implements SeckillProductStrategy {

    private static final Logger logger = LoggerFactory.getLogger(SeckillProductAOPStrategy.class);

    private SeckillService seckillService;

    public SeckillProductAOPStrategy(SeckillService seckillService) {
        this.seckillService = seckillService;
    }

    @Override
    public Integer seckillProduct(SeckillProduct seckillProduct, SeckillOrder seckillOrder, SeckillUserResult seckillUserResult) {
        logger.info("seckillProduct AOP入参seckillProduct：{} seckillOrder：{} seckillUserResult：{}", seckillProduct, seckillOrder, seckillUserResult);
        return seckillService.seckillProductAOP(seckillProduct, seckillOrder, seckillUserResult);
    }

}
