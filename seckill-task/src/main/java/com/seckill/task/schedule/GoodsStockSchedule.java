package com.seckill.task.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 商品添加库存的提醒
 * @author xianzhixianzhixian
 * @date 2020/03/04 16:53
 */
public class GoodsStockSchedule extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(GoodsStockSchedule.class);


    /**
     * 每当触发的时候会执行方法中的内容
     * @param context
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("商品库存检查定时任务启动");
        logger.info("商品库存检查定时任务结束");
    }
}
