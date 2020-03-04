package com.seckill.manager.producttype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ManagerProductTypeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerProductTypeApplication.class, args);
    }

}
