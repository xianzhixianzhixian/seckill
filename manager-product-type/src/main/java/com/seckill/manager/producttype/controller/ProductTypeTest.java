package com.seckill.manager.producttype.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by li on 2019/2/2.
 */
@RestController
public class ProductTypeTest {


    @RequestMapping(value = "sayHelloWorld",method = RequestMethod.GET)
    public String sayHelloWorld(HttpServletRequest req){
        String remoteAddr = req.getRemoteAddr();
        return "hello "+ remoteAddr +" !!";
    }
}
