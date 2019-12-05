package com.seckill.product.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.ReadMode;
import org.redisson.config.SubscriptionMode;
import org.redisson.config.TransportMode;
import org.redisson.connection.balancer.RoundRobinLoadBalancer;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedissonConfig {

    @Value("${spring.redis.cluster.nodes}")
    private String clusterNodes;
    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public RedissonClient redissonClient() throws Exception {
        String[] nodes = clusterNodes.split(",");
        //redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
        for (int i=0; i<nodes.length; i++) {
            nodes[i] = "redis://"+nodes[i];
        }

        Config config = new Config();
        config.setTransportMode(TransportMode.NIO);
        config.useClusterServers()
              .addNodeAddress(nodes)
              .setPassword(password)
              .setRetryAttempts(3)
              .setRetryInterval(1500)
              .setSubscriptionsPerConnection(5)
              .setLoadBalancer(new RoundRobinLoadBalancer())
              .setSubscriptionMode(SubscriptionMode.SLAVE)
              .setScanInterval(3000)
              .setReadMode(ReadMode.SLAVE);
        return Redisson.create(config);
    }

    @Bean
    public RedissonConnectionFactory redissonConnectionFactory(RedissonClient redissonClient) {
        return new RedissonConnectionFactory(redissonClient);
    }

    @Bean
    public RedisSerializer keySerializer() {
        return new StringRedisSerializer();
    }

    @Bean
    public RedisSerializer valueSerializer() {
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return jackson2JsonRedisSerializer;
    }
}
