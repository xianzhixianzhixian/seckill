package com.seckill.product.event.handler;

import com.seckill.product.event.CentralEventProcessor;
import com.seckill.product.event.entity.Event;
import com.seckill.product.event.entity.OrderEvent;
import com.seckill.product.event.entity.SeckillProductEvent;
import com.seckill.product.event.state.OrderEventType;
import com.seckill.product.event.state.SeckillEventType;
import com.seckill.product.event.state.handler.StateHandler;
import com.seckill.product.service.SeckillService;
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
            Long userId = seckillProductEvent.getUserId();
            Long seckillProductId = seckillProductEvent.getSeckillProductId();
            SeckillService seckillService = seckillProductEvent.getSeckillService();
            seckillService.multipltThreadSeckillProduct(userId, seckillProductId);
            Event seckillCompleteEvent = new SeckillProductEvent(
                    seckillProductEvent.getName(),
                    SeckillEventType.COMPLETE,
                    userId,
                    seckillProductId,
                    seckillService,
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

    public class CompleteSeckillStateHandler implements StateHandler {

        @Override
        public void hanlde(Event event) {
            logger.info("SeckillEventHandler Complete处理{}", event);
            SeckillProductEvent seckillCompleteEvent = (SeckillProductEvent) event;
            Event orderNewEvent = new OrderEvent(
                    seckillCompleteEvent.getName(),
                    OrderEventType.NEW,
                    seckillCompleteEvent.getUserId(),
                    seckillCompleteEvent.getSeckillProductId(),
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
