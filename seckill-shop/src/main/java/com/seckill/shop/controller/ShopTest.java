package com.seckill.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ShopTest {


    @RequestMapping(value = "sayHelloWorld",method = RequestMethod.GET)
    public String sayHelloWorld(HttpServletRequest req){
        String remoteAddr = req.getRemoteAddr();
        return "hello "+ remoteAddr +" !!";
    }
}
