package com.waibizi.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 16:38
 * @Description:
 * @Version 1.0
 */
@Configuration
@Profile("single")
/* 开启spring cache注解功能 */
@EnableCaching
public class RedisConfig {
    @Bean
    public LettuceConnectionFactory redisConnectionFactory(){
        System.out.println("单机版本Redis");
        return new LettuceConnectionFactory(
                new RedisStandaloneConfiguration("192.168.72.130",6379)
        );
    }
    @Bean
    public RedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate redisTemplate = new RedisTemplate();
        /* 设置连接工厂 */
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        /* 当我们的数据存储到Redis的时候，我们的键（key）和值（value）都是通过Spring提供的Serializer序列化到数据库的 */
        /* RedisTemplate默认使用的是JdkSerializationRedisSerializer，StringRedisTemplate默认使用的是StringRedisSerializer */
        /* JdkSerializationRedisSerializer: 使用JDK提供的序列化功能。
        优点是反序列化时不需要提供类型信息(class)，但缺点是需要实现Serializable接口，
        还有序列化后的结果非常庞大，是JSON格式的5倍左右，这样就会消耗redis服务器的大量内存 */
        /* Jackson2JsonRedisSerializer：使用Jackson库将对象序列化为JSON字符串。
        优点是速度快，序列化后的字符串短小精悍，不需要实现Serializable接口。但缺点也非常致命，
        那就是此类的构造函数中有一个类型参数，必须提供要序列化对象的类型信息(.class对象)。 */
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return redisTemplate;
    }
    /* 配置Spring Cache注解功能 */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
        return cacheManager;
    }
}
