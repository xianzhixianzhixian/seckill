package com.seckill.product.event.handler;


import com.seckill.common.entity.event.Event;

/**
 * 状态处理方法
 * @author xianzhixianzhixian on 2019/12/22 23:20
 */
public interface StateHandler {

    void hanlde(Event event);
}
