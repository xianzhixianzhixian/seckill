package com.seckill.merchant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SeckillMerchantApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeckillMerchantApplication.class, args);
    }
}
