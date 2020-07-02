package com.waibizi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 19:00
 * @Description:
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class List_Test {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){

    }
}
