package com.seckill.order.service.impl;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.entity.OrderRequest;
import com.seckill.common.utils.TradeSeqNumberUtils;
import com.seckill.order.mapper.SeckillOrderMapper;
import com.seckill.order.service.SeckillOrderService;
import com.seckill.order.service.feign.SeckillProductFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillOrderServiceImpl.class);

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;
    @Autowired
    private SeckillProductFeignService seckillProductFeignService;

    @Transactional
    @Override
    public Integer createNewOrder(SeckillOrder seckillOrder) throws Exception {
        Integer result = 0;
        seckillOrder.setCreatedTime(new Date());
        seckillOrder.setPayType(0);
        String tradeSeqNum = TradeSeqNumberUtils.getTradeSeqNummber();
        seckillOrder.setTradeSerialNumber(tradeSeqNum);
        seckillOrder.setOrderFlag(0);
        try {
            result = seckillOrderMapper.insert(seckillOrder);
        } catch (Exception e) {
            logger.error("createNewOrder{}错误，原因{}", seckillOrder, e);
            throw e;
        }
        return result;
    }

    @Transactional
    @Override
    public Integer createNewOrder(OrderRequest orderRequest) throws Exception {
        Long userId = orderRequest.getUserId();
        Long seckillProductId = orderRequest.getSeckillProductId();
        Long shopId = orderRequest.getShopId();
        SeckillProduct seckillProduct = seckillProductFeignService.findSeckillProductBySeckillProductId(seckillProductId);
        SeckillOrder seckillOrder = new SeckillOrder();
        seckillOrder.setSeckillProductId(seckillProductId);
        seckillOrder.setProductId(seckillProduct.getProductId());
        seckillOrder.setPayAmount(seckillProduct.getSeckillPrice());
        seckillOrder.setSeckillNum(seckillProduct.getSeckillNum());
        seckillOrder.setUserId(userId);
        seckillOrder.setShopId(shopId);
        seckillOrder.setCreateTime(new Date());
        //未支付
        seckillOrder.setPayStatus(0);
        seckillOrder.setTradeSerialNumber(TradeSeqNumberUtils.getTradeSeqNummber());
        //正常
        seckillOrder.setOrderFlag(0);
        return seckillOrderMapper.insertSelective(seckillOrder);
    }
}
