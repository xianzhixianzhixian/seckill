package com.seckill.task.schedule;

import com.seckill.common.bean.SeckillOrder;
import com.seckill.common.bean.SeckillResult;
import com.seckill.common.utils.JsonUtils;
import com.seckill.task.service.feign.SeckillOrderFeignService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Calendar;
import java.util.List;

/**
 * 订单超时未支付的定时任务
 * @author xianzhixianzhixian
 * @date 2020/03/04 16:56
 */
public class OrderPayTimeoutSchedule extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(OrderPayTimeoutSchedule.class);

    @Autowired
    private SeckillOrderFeignService seckillOrderFeignService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Integer result = 0;
        logger.info("订单超时未支付定时任务启动");
        SeckillResult seckillResult = seckillOrderFeignService.listSeckillOrderByTime(Calendar.MINUTE, -20, 0, 0);
        List<SeckillOrder> seckillOrderList = JsonUtils.jsonToList((String) seckillResult.getData(), SeckillOrder.class);
        logger.info("超时未支付订单：{}", seckillOrderList);
        try {
            for (SeckillOrder seckillOrder : seckillOrderList) {
                //设置为超时取消
                seckillOrder.setOrderFlag(2);
                seckillResult = seckillOrderFeignService.updateSeckillOrderById(seckillOrder);
                result = result + (Integer) seckillResult.getData();
            }
        } catch (Exception e) {
            logger.error("超时订单处理错误，原因{}", e);
        }
        logger.info("订单超时未支付定时任务结束，自动取消订单数{}", result);
    }
}
