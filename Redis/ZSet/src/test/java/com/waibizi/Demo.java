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
 * @Date 2020/6/28 18:58
 * @Description:
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo {




    @Autowired
    private RedisTemplate redisTemplate;
    /**
     *
     */
    @Test
    public void SetValue(){
        /* 存值参考这里 */
        redisTemplate.boundZSetOps("金主爸爸").add("歪鼻子",3306);
        redisTemplate.boundZSetOps("金主爸爸").add("小乔",8848);
        redisTemplate.boundZSetOps("金主爸爸").add("鲁班",10000);
        redisTemplate.boundZSetOps("金主爸爸").add("夏侯惇",10);
    }

    /**
     * 屌丝榜
     */
    @Test
    public void GetIncValue(){
        /**
         * 伪代码
         * 1.先存值，存值策略你自己选择
         * 2.取值，如果值存在，先走redis，如果不存在，走SQL
         * 3.取值参考下面
         * (考虑并发可以加锁，考虑缓存数据一致性可以参考缓存一致性)
         */
        Set set = redisTemplate.boundZSetOps("金主爸爸").range(0, -1);
        System.out.println(set);
    }
    /**
     * 土豪榜
     */
    @Test
    public void GetDesrValue(){
        Set set = redisTemplate.boundZSetOps("金主爸爸").reverseRange(0,-1);
    }
}



