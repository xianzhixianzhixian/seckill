package com.seckill.product.event.handler;

import com.seckill.product.event.CentralEventProcessor;
import com.seckill.product.event.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingDeque;

/**
 * 订单事件处理器
 * @author xianzhixianzhixian on 20191218
 */
public class OrderEventHandler implements Handler {

    private static final Logger logger = LoggerFactory.getLogger(OrderEventHandler.class);

    private CentralEventProcessor centralEventProcessor;

    public OrderEventHandler() {
    }

    public OrderEventHandler(CentralEventProcessor centralEventProcessor) {
        this.centralEventProcessor = centralEventProcessor;
    }

    /**
     * 秒杀事件处理器
     */
    @Override
    public void handler(Event event) {
        logger.info("订单事件处理器开始处理事件{}", event);
        try {
            //这里只进行订单事件的处理
        } catch (Exception e) {
            logger.error("秒杀事件处理器放入事件失败，原因{}", e);
        }
    }
}
