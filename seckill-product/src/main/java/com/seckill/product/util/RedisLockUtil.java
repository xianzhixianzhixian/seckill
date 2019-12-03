package com.seckill.product.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Collections;

/**
 * Redis工具类
 * 20191203 22:19
 */
@Component
public class RedisLockUtil {

    private static Logger logger = LoggerFactory.getLogger(RedisLockUtil.class);

    private static final Long LOCK_RELEASE_SUCCESS = 1L;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 尝试获取Redis锁并设置过期时间
     * @param lockKey
     * @param requestId
     * @param expireTime
     * @return
     */
    public Boolean tryRedisLock(String lockKey, String requestId, Duration expireTime) {
        return redisTemplate.opsForValue().setIfAbsent(lockKey, requestId, expireTime);
    }

    /**
     * 解锁Redis锁
     * @param lockKey
     * @param requestId
     * @return
     */
    public Boolean releaseRedisLock(String lockKey, String requestId) {
        RedisScript<String> redisScript = RedisScript.of("if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else retuen 0 end");
        Object result = redisTemplate.execute(redisScript, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (LOCK_RELEASE_SUCCESS.equals(result)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
