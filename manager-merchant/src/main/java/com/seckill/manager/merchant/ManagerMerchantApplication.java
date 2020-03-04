package com.seckill.manager.merchant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ManagerMerchantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerMerchantApplication.class, args);
    }

}
