package com.seckill.product.event;

import com.seckill.common.entity.event.Event;
import com.seckill.product.event.entity.CentralForwardEvent;
import com.seckill.product.event.entity.OrderEvent;
import com.seckill.product.event.entity.SeckillProductEvent;
import com.seckill.product.event.handler.CentralEventForwardHandler;
import com.seckill.product.event.handler.Handler;
import com.seckill.product.event.handler.OrderEventHandler;
import com.seckill.product.event.handler.SeckillEventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 中央事件处理器
 */
public class CentralEventProcessor {

    private final static Logger logger = LoggerFactory.getLogger(CentralEventProcessor.class);

    //事件转发器
    private Map<Class, Handler> eventForwarder = new HashMap<>();
    //中央处理队列
    private BlockingDeque<Event> centralEventQueue = new LinkedBlockingDeque<>();
    //中央事件处理器
    private CentralProcessor centralProcessor = new CentralProcessor();

    public CentralEventProcessor() {
        Handler seckillHandler = new SeckillEventHandler(this);
        eventForwarder.put(SeckillProductEvent.class, seckillHandler);
        Handler orderEventHandler = new OrderEventHandler(this);
        eventForwarder.put(OrderEvent.class, orderEventHandler);
        Handler centralEventHandler = new CentralEventForwardHandler(this);
        eventForwarder.put(CentralForwardEvent.class, centralEventHandler);
        //TODO 思考这里存在的问题，每次创建一个新的实例就会有一个新的线程被创建
        new Thread(centralProcessor).start();
    }

    public BlockingDeque<Event> getCentralEventQueue() {
        return centralEventQueue;
    }

    /**
     * 中央事件处理器，调用不同的事件处理器进行处理
     */
    class CentralProcessor implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    //take会阻塞直到队列中有值为止
                    Event event = centralEventQueue.take();
                    Handler handler = eventForwarder.get(event.getClass());
                    logger.info("中央事件处理器{}开始处理事件{}", handler, event);
                    if (handler != null) {
                        handler.handler(event);
                    }
                } catch (Exception e) {
                    logger.error("centralEventQueue取出事件出错，原因{}", e);
                }
            }
        }
    }
}
