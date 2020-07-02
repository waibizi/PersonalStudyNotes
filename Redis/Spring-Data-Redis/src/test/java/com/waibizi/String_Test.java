package com.waibizi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 18:46
 * @Description:
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class String_Test {

//    public void setRedisTemplateConfig(){
//        /* 当我们的数据存储到Redis的时候，我们的键（key）和值（value）
//        都是通过Spring提供的Serializer序列化到数据库的。
//        RedisTemplate默认使用的是JdkSerializationRedisSerialize
//        */
//        /* JdkSerializationRedisSerializer: 使用JDK提供的序列化功能。
//        优点是反序列化时不需要提供类型信息(class)，
//        但缺点是需要实现Serializable接口，还有序列化后的结果非常庞大，
//        是JSON格式的5倍左右，这样就会消耗redis服务器的大量内存。
//         */
//        /*
//        Jackson2JsonRedisSerializer： 使用Jackson库将对象序列化为JSON字符串。
//        优点是速度快，序列化后的字符串短小精悍，不需要实现Serializable接口。
//        但缺点也非常致命，那就是此类的构造函数中有一个类型参数，必须提供要序列化对象的类型信息(.class对象)。
//         */
//        redisTemplate.setDefaultSerializer(new JdkSerializationRedisSerializer());
//    }
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void setValue(){
        redisTemplate.opsForValue().set("鲁班","20");
    }
    @Test
    public void getValue(){
        System.out.println(redisTemplate.opsForValue().get("鲁班"));
    }
}
