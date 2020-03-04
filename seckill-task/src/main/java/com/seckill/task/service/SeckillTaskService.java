package com.seckill.task.service;

public interface SeckillTaskService {

    /**
     * 启动支付超时订单检查任务
     * @return
     * @throws Exception
     */
    void startOrderPayTimeoutSchedule() throws Exception;
}
