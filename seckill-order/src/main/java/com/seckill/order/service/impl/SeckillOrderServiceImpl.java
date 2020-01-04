package com.seckill.order.service.impl;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.utils.TradeSeqNumberUtils;
import com.seckill.order.mapper.SeckillOrderMapper;
import com.seckill.order.service.SeckillOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillOrderServiceImpl.class);

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Override
    public Integer createNewOrder(SeckillOrder seckillOrder) throws Exception {
        Integer result = 0;
        seckillOrder.setCreatedTime(new Date());
        seckillOrder.setPayType(0);
        String tradeSeqNum = TradeSeqNumberUtils.getTradeSeqNummber();
        seckillOrder.setId(tradeSeqNum);
        seckillOrder.setTradeSerialNumber(tradeSeqNum);
        seckillOrder.setOrderFlag(0);
        try {
            result = seckillOrderMapper.insert(seckillOrder);
        } catch (Exception e) {
            logger.error("createNewOrder错误，原因{}", e);
            throw e;
        }
        return result;
    }
}
