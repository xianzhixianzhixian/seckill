package com.seckill.task.controller;

import com.seckill.common.bean.SeckillResult;
import com.seckill.common.constant.SeckillReturnCodeType;
import com.seckill.task.service.impl.SeckillTaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/task")
@RestController
public class SeckillTaskController {

    @Autowired
    private SeckillTaskServiceImpl seckillTaskService;

    @RequestMapping("/startOrderPayTimeoutSchedule")
    public SeckillResult startOrderPayTimeoutSchedule() {
        try {
            seckillTaskService.startOrderPayTimeoutSchedule();
            return new SeckillResult(SeckillReturnCodeType.SUCCESS_CODE, "创建订单检查任务成功");
        } catch (Exception e) {
            return new SeckillResult(SeckillReturnCodeType.SYSTEM_ERROR, "创建订单检查任务失败", e);
        }
    }
}
