package com.seckill.product.event.handler;

import com.seckill.product.event.CentralEventProcessor;
import com.seckill.product.event.entity.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.BlockingDeque;

/**
 * 中央处理器转发事件处理器
 */
public class CentralEventForwardHandler implements Handler {

    private final static Logger logger = LoggerFactory.getLogger(CentralEventForwardHandler.class);

    private CentralEventProcessor centralEventProcessor;

    public CentralEventForwardHandler() {
    }

    public CentralEventForwardHandler(CentralEventProcessor centralEventProcessor) {
        this.centralEventProcessor = centralEventProcessor;
    }

    @Override
    public void handler(Event event) {
        logger.info("中央事件处理队列存储事件{}", event);
        try {
            //这里只进行所有事件的搜集
            BlockingDeque<Event> centralEventQueue = centralEventProcessor.getCentralEventQueue();
            if (centralEventQueue != null) {
                centralEventQueue.put(event);
            }
        } catch (Exception e) {
            logger.error("centralEventQueue放入事件{}出错，原因{}", event, e);
        }
    }
}
