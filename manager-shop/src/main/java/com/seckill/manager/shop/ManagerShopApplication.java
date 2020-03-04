package com.seckill.manager.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ManagerShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerShopApplication.class, args);
    }

}
