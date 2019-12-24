package com.seckill.product.event.state.handler;

import com.seckill.product.event.entity.Event;

/**
 * 状态处理方法
 * @author xianzhixianzhixian on 2019/12/22 23:20
 */
public interface StateHandler {

    void hanlde(Event event);
}
