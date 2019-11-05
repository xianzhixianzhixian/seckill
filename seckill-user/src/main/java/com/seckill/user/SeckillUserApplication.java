package com.seckill.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SeckillUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillUserApplication.class, args);
    }

}
