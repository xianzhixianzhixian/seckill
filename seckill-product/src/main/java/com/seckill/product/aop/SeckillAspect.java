package com.seckill.product.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 秒杀服务切面锁
 */
@Aspect
@Component
public class SeckillAspect {

    private static final Logger logger = LoggerFactory.getLogger(SeckillAspect.class);
    private static Lock lock = new ReentrantLock();

    @Pointcut("execution(public * com.seckill.product.service.impl.SeckillServiceImpl.seckillProduct(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        lock.lock();
        Object object = null;
        try {
            logger.info("执行around步骤");
            object = proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            logger.error("around发生异常，原因{}", t);
        } finally {
            lock.unlock();
        }
        return object;
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
