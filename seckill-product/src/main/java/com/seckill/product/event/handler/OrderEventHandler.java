package com.seckill.product.event.handler;

import com.seckill.common.entity.OrderRequest;
import com.seckill.product.event.CentralEventProcessor;
import com.seckill.product.event.entity.Event;
import com.seckill.product.event.entity.OrderEvent;
import com.seckill.product.event.state.OrderEventType;
import com.seckill.product.event.state.handler.StateHandler;
import com.seckill.product.service.SeckillMessageFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;

/**
 * 订单事件处理器
 * @author xianzhixianzhixian on 20191218
 */
public class OrderEventHandler implements Handler {

    private static final Logger logger = LoggerFactory.getLogger(OrderEventHandler.class);

    private CentralEventProcessor centralEventProcessor;

    private OrderStateMechine orderStateMechine = new OrderStateMechine();

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
            StateHandler orderStateHandler = orderStateMechine.getStateHandler(event.getEventType());
            orderStateHandler.hanlde(event);
        } catch (Exception e) {
            logger.error("秒杀事件处理器放入事件失败，原因{}", e);
        }
    }

    public class OrderStateMechine {

        //存储状态处理器
        private Map<String, StateHandler> orderStateHanlerCollector = new HashMap<>();

        public OrderStateMechine() {
            orderStateHanlerCollector.put(OrderEventType.NEW, new NewOrderStateHandler());
            orderStateHanlerCollector.put(OrderEventType.COMPLETE, new CompleteOrderStateHandler());
            orderStateHanlerCollector.put(OrderEventType.FAIL, new FailOrderStateHandler());
            orderStateHanlerCollector.put(OrderEventType.RUNNING, new RunningOrderStateHandler());
        }

        public StateHandler getStateHandler(String orderEventType) {
            return orderStateHanlerCollector.get(orderEventType);
        }
    }

    public class NewOrderStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("OrderEventHandler New处理{}", event);
            OrderEvent orderEvent = (OrderEvent) event;
            Long userId = orderEvent.getUserId();
            Long seckillProductId = orderEvent.getSeckillProductId();
            SeckillMessageFeignService seckillMessageFeignService = orderEvent.getSeckillMessageFeignService();
            //发送消息到RabbitMQ
            OrderRequest orderRequest = new OrderRequest();
            orderRequest.setUserId(userId);
            orderRequest.setSeckillProductId(seckillProductId);
            seckillMessageFeignService.sendOrderMessage(orderRequest);
        }

    }

    public class CompleteOrderStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("OrderEventHandler Complete处理{}", event);
        }

    }

    public class FailOrderStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("OrderEventHandler Fail处理{}", event);
        }

    }

    public class RunningOrderStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("OrderEventHandler Running处理{}", event);
        }

    }
}
