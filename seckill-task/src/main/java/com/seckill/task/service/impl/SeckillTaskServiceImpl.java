package com.seckill.task.service.impl;

import com.seckill.common.constant.SeckillTaskType;
import com.seckill.task.schedule.OrderPayTimeoutSchedule;
import com.seckill.task.service.SeckillTaskService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SeckillTaskServiceImpl implements SeckillTaskService {

    private static final Logger logger = LoggerFactory.getLogger(SeckillTaskServiceImpl.class);

    @Autowired
    private Scheduler scheduler;

    public void startOrderPayTimeoutSchedule() throws Exception {
        //任务名称
        String taskName = SeckillTaskType.OREDRE_SCHEDULE + UUID.randomUUID();
        //任务分组
        String taskGroupName = SeckillTaskType.OREDRE_SCHEDULE;
        //30s执行一次
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * * * ?");
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(OrderPayTimeoutSchedule.class).withIdentity(taskName, taskGroupName).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(taskName, taskGroupName).withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);
        logger.info("开启startOrderPayTimeoutSchedule");
    }
}
