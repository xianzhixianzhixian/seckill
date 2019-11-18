package com.seckill.registercenter;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SeckillRegisterCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillRegisterCenterApplication.class, args);
    }
}