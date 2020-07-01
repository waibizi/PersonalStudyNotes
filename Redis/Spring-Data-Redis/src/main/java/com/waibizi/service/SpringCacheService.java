package com.waibizi.service;

import com.waibizi.pojo.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Author 歪鼻子
 * @Date 2020/7/1 17:01
 * @Description:
 * @Version 1.0
 */
@Profile("single")
public class SpringCacheService {
    @Cacheable(cacheManager = "cacheManager",value = "cache-1",key = "#userId")
    public User findUserByName(String name) throws Exception{
        /* 模拟读取数据库 */
        User user = new User("歪鼻子",18);
    }
}
