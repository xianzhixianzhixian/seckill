package com.seckill.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeckillTaskApplication {

    private static final Logger logger = LoggerFactory.getLogger(SeckillTaskApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SeckillTaskApplication.class, args);
        logger.info("秒杀系统分布式任务调度程序已启动");
    }

}
