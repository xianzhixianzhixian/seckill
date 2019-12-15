package com.seckill.product.util;

import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedissonLockUtil {

    private final Logger logger = LoggerFactory.getLogger(RedissonLockUtil.class);

    public static final Long WAIT_LOCK_TIME = 30L;
    public static final Long LOCK_TIME = 10L;

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 获取公平锁
     * @param lockName
     * @return
     */
    public RLock getFairLock(String lockName) {
        String threadName =Thread.currentThread().getName();
        logger.info("线程{} getFairLock ，lockName {}", threadName, lockName);
        RLock rLock = null;
        if (StringUtils.isEmpty(lockName)) {
            return rLock;
        }
        try {
            rLock = redissonClient.getFairLock(lockName);
        } catch (Throwable t) {
            logger.error("线程{} getFairLock 错误，原因{}", Thread.currentThread().getName(), t);
        }
        return rLock;
    }

    /**
     * 同步获取锁
     * @param rLock
     * @param waitTime
     * @param lockTime
     * @param timeUnit
     * @return
     */
    public Boolean tryLock(RLock rLock, Long waitTime, Long lockTime, TimeUnit timeUnit) {
        String threadName =Thread.currentThread().getName();
        logger.info("线程{} tryLock ，waitTime {}, lockTime {}, timeUnit {}", threadName, waitTime, lockTime, timeUnit);
        Boolean lockResult = false;
        if (rLock == null) {
            return lockResult;
        }
        try {
            lockResult = rLock.tryLock(waitTime, lockTime, timeUnit);
        } catch (Throwable t) {
            logger.error("线程{} tryLock 错误，原因{}", threadName, t);
        }
        return lockResult;
    }

    /**
     * 解除Redis锁
     * @param rLock
     */
    public void unlock(RLock rLock) {
        String threadName =Thread.currentThread().getName();
        logger.info("线程{} unlock ，rLock {}, lockTime {}, timeUnit {}", threadName, rLock.getName());
        try {
            if (rLock != null && rLock.isLocked() && rLock.isHeldByCurrentThread()) {
                rLock.unlock();
            }
        } catch (Throwable t) {
            logger.error("线程{} tryLock 错误，原因{}", threadName, t);
        }
    }

    /**
     * 给Redis设置键值返回设置的值(未加Redis锁但是这个方法是同步的)
     */
    public String addToBucket(String key, String value) {
        String threadName =Thread.currentThread().getName();
        logger.info("线程{} addToBucket ，key {}, value {}", threadName, key, value);
        RBucket rBucket = redissonClient.getBucket(key);
        return (String) rBucket.getAndSet(value);
    }

    /**
     * 获取键值对中的value
     * @param key
     * @return
     */
    public String getFromBucket(String key) {
        RBucket rBucket = redissonClient.getBucket(key);
        return (String) rBucket.get();
    }
}
