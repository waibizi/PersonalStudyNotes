package com.waibizi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 19:03
 * @Description:
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZSet_Test {
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void SetValue(){
        /* 存值参考这里 */
        redisTemplate.boundZSetOps("金主爸爸").add("歪鼻子",3306);
        redisTemplate.boundZSetOps("金主爸爸").add("小乔",8848);
        redisTemplate.boundZSetOps("金主爸爸").add("鲁班",10000);
        redisTemplate.boundZSetOps("金主爸爸").add("夏侯惇",10);
    }
    @Test
    public void GetIncValue(){
        Set set = redisTemplate.boundZSetOps("金主爸爸").range(0, -1);
        System.out.println(set);
    }
    @Test
    public void GetDesrValue(){
        /* 默认是是升序 */
        Set set = redisTemplate.boundZSetOps("金主爸爸").reverseRange(0,-1);
    }
}
