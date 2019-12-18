package com.seckill.product.event.handler;

import com.seckill.product.event.entity.Event;

/**
 * 事件处理器
 */
public interface Handler {

    /**
     * 处理事件
     * @param event
     */
    void handler(Event event);
}
