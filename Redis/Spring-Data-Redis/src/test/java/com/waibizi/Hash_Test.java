package com.waibizi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 19:02
 * @Description:
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Hash_Test {
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void SetValue(){
        redisTemplate.boundHashOps("信息").put("歪鼻子",26);
    }
    @Test
    public void GetValue(){
        System.out.println(redisTemplate.boundHashOps("信息").get("歪鼻子"));
    }
}
