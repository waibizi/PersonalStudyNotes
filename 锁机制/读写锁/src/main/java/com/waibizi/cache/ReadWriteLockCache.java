package com.waibizi.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author 歪鼻子
 * @Date 2020/6/13 2:17
 * @Description:
 * @Version 1.0
 */
public class ReadWriteLockCache {
    //这里的map可以是大家日常用的redis之类的，为了方便我就采用map这种天然的key/val模拟
    private Map<String,String> cache = new HashMap<>();
    //定义读写锁
    private ReadWriteLock rwLock = new ReentrantReadWriteLock();
    public String get(String key){
        rwLock.readLock().lock();
        String val = null;
        try {
            val = cache.get(key);
            if (val == null){
                //释放读锁
                rwLock.readLock().unlock();
                //加上读锁
                rwLock.writeLock().lock();
                if (val == null){
                    val = "数据库操作";
                }
            }
        }finally {
            rwLock.writeLock().unlock();
        }
        return val;
    }
}
