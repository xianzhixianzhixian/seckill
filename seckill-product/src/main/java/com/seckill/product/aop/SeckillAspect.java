package com.seckill.product.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 秒杀服务切面锁
 */
@Aspect
@Component
public class SeckillAspect {

    private static final Logger logger = LoggerFactory.getLogger(SeckillAspect.class);

    @Pointcut("execution(public * com.seckill.product.controller.*.*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {}", request.getRequestURI());
        logger.info("method = {}", request.getMethod());
        logger.info("ip = {}", request.getRemoteAddr());
        logger.info("class = {} and methodName={}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        logger.info("parameters = {}", joinPoint.getArgs());
    }

    @After("pointcut()")
    public void after() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url = {} end of execution", request.getRequestURL());
    }

    @AfterReturning(returning = "object", pointcut = "pointcut()")
    public void afterReturning(Object object) {
        if (object != null) {
            logger.info("response = {}", object);
        } else {
            logger.info("response = {}", object);
        }
    }
}
