package com.seckill.product.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 中央事件处理器
 */
public class CentralEventProcessor {

    private final static Logger logger = LoggerFactory.getLogger(CentralEventProcessor.class);

    //事件转发器
    private Map<Event, Handler> eventForwarder = new HashMap<>();

    //中央处理队列
    private BlockingDeque<Event> centralEventQueue = new LinkedBlockingDeque<>();

    class CentralEventForwardor implements Handler {

        @Override
        public void handler(Event event) {
            try {
                centralEventQueue.put(event);
            } catch (Exception e) {
                logger.error("centralEventQueue放入事件{}出错，原因{}", event, e);
            }
        }
    }

    class EventProcessor implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Event event = centralEventQueue.take();
                    Handler handler = eventForwarder.get(event);
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
