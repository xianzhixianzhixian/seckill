package com.seckill.product.event.handler;

import com.seckill.common.bean.SeckillProduct;
import com.seckill.product.event.CentralEventProcessor;
import com.seckill.product.event.entity.Event;
import com.seckill.product.event.entity.OrderEvent;
import com.seckill.product.event.entity.SeckillProductEvent;
import com.seckill.product.event.state.OrderEventType;
import com.seckill.product.event.state.SeckillEventType;
import com.seckill.product.event.state.handler.StateHandler;
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
            Event seckillNewEvent = new SeckillProductEvent(SeckillEventType.NEW, SeckillEventType.NEW);
            BlockingDeque<Event> eventBlockingDeque = centralEventProcessor.getCentralEventQueue();
            StateHandler seckillStateHandler = seckillStateMechine.getStateHandlerByEventType(SeckillEventType.NEW);
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
            Event seckillCompleteEvent = new SeckillProductEvent(SeckillEventType.COMPLETE, SeckillEventType.COMPLETE);
            logger.info("SeckillEventHandler New处理{}", seckillCompleteEvent);
            BlockingDeque<Event> eventBlockingDeque = centralEventProcessor.getCentralEventQueue();
            try {
                eventBlockingDeque.put(seckillCompleteEvent);
            } catch (Exception e) {
                logger.error("SeckillEventHandler New处理{}错误，原因{}", seckillCompleteEvent, e);
            }
        }

    }

    public class CompleteSeckillStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            Event orderNewEvent = new OrderEvent(OrderEventType.NEW, OrderEventType.NEW);
            logger.info("SeckillEventHandler Complete处理{}", event);
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
