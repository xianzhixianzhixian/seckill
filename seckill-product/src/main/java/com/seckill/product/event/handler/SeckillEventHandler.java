package com.seckill.product.event.handler;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillProduct;
import com.seckill.common.bean.SeckillUserResult;
import com.seckill.common.entity.event.Event;
import com.seckill.common.entity.event.type.OrderEventType;
import com.seckill.common.entity.event.type.SeckillEventType;
import com.seckill.product.event.CentralEventProcessor;
import com.seckill.product.event.entity.OrderEvent;
import com.seckill.product.event.entity.SeckillProductEvent;

import com.seckill.product.strategy.SeckillProductStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;

/**
 * 秒杀事件处理器
 */
public class SeckillEventHandler implements Handler {

    private static final Logger logger = LoggerFactory.getLogger(SeckillEventHandler.class);

    private CentralEventProcessor centralEventProcessor;

    private SeckillStateMechine seckillStateMechine = new SeckillStateMechine();

    public SeckillEventHandler() {
    }

    public SeckillEventHandler(CentralEventProcessor centralEventProcessor) {
        this.centralEventProcessor = centralEventProcessor;
    }

    /**
     * 秒杀事件处理器
     */
    @Override
    public void handler(Event event) {
        logger.info("秒杀事件处理器开始处理事件{}", event);
        try {
            //这里只进行秒杀事件的处理
            StateHandler seckillStateHandler = seckillStateMechine.getStateHandlerByEventType(event.getEventType());
            seckillStateHandler.hanlde(event);
        } catch (Exception e) {
            logger.error("秒杀事件处理器放入事件失败，原因{}", e);
        }
    }

    public class SeckillStateMechine {

        //存储状态处理器
        private Map<String, StateHandler> seckillStateHanlerCollector = new HashMap<>();

        public SeckillStateMechine() {
            seckillStateHanlerCollector.put(SeckillEventType.NEW, new SeckillEventHandler.NewSeckillStateHandler());
            seckillStateHanlerCollector.put(SeckillEventType.COMPLETE, new SeckillEventHandler.CompleteSeckillStateHandler());
            seckillStateHanlerCollector.put(SeckillEventType.FAIL, new SeckillEventHandler.FailSeckillStateHandler());
            seckillStateHanlerCollector.put(SeckillEventType.RUNNING, new SeckillEventHandler.RunningSeckillStateHandler());
        }

        public StateHandler getStateHandlerByEventType(String seckillProductEventType) {
            return seckillStateHanlerCollector.get(seckillProductEventType);
        }
    }

    public class NewSeckillStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("SeckillEventHandler New处理{}", event);
            SeckillProductEvent seckillProductEvent = (SeckillProductEvent) event;
            SeckillProduct seckillProduct = seckillProductEvent.getSeckillProduct();
            SeckillOrder seckillOrder = seckillProductEvent.getSeckillOrder();
            SeckillUserResult seckillUserResult = seckillProductEvent.getSeckillUserResult();
            SeckillProductStrategy seckillProductStrategy = seckillProductEvent.getSeckillProductStrategy();
            Integer result = seckillProductStrategy.seckillProduct(seckillProduct, seckillOrder, seckillUserResult);
            //秒杀正在生成订单表示秒杀步骤已经通过，只剩订单生成步骤
            if (result == 2) {
                //成功
                Event seckillCompleteEvent = new SeckillProductEvent(
                        seckillProductEvent.getName(),
                        SeckillEventType.COMPLETE,
                        seckillProduct,
                        seckillOrder,
                        seckillUserResult,
                        seckillProductEvent.getSeckillService(),
                        seckillProductEvent.getSeckillUserResultService(),
                        seckillProductStrategy,
                        seckillProductEvent.getSeckillMessageFeignService()
                );
                BlockingDeque<Event> eventBlockingDeque = centralEventProcessor.getCentralEventQueue();
                try {
                    eventBlockingDeque.put(seckillCompleteEvent);
                } catch (Exception e) {
                    logger.error("SeckillEventHandler New处理{}错误，原因{}", seckillCompleteEvent, e);
                }
            }
        }

    }

    public class CompleteSeckillStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("SeckillEventHandler Complete处理{}", event);
            SeckillProductEvent seckillCompleteEvent = (SeckillProductEvent) event;
            SeckillProduct seckillProduct = seckillCompleteEvent.getSeckillProduct();
            SeckillOrder seckillOrder = seckillCompleteEvent.getSeckillOrder();
            SeckillUserResult seckillUserResult = seckillCompleteEvent.getSeckillUserResult();
            Event orderNewEvent = new OrderEvent(
                    seckillCompleteEvent.getName(),
                    OrderEventType.NEW,
                    seckillProduct,
                    seckillOrder,
                    seckillUserResult,
                    seckillCompleteEvent.getSeckillService(),
                    seckillCompleteEvent.getSeckillUserResultService(),
                    seckillCompleteEvent.getSeckillProductStrategy(),
                    seckillCompleteEvent.getSeckillMessageFeignService()
            );
            BlockingDeque<Event> eventBlockingDeque = centralEventProcessor.getCentralEventQueue();
            try {
                eventBlockingDeque.put(orderNewEvent);
            } catch (Exception e) {
                logger.error("SeckillEventHandler Complete处理{}错误，原因{}", orderNewEvent, e);
            }
        }

    }

    public class FailSeckillStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("SeckillEventHandler Fail处理{}", event);
        }

    }

    public class RunningSeckillStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("SeckillEventHandler Running处理{}", event);
        }

    }
}
