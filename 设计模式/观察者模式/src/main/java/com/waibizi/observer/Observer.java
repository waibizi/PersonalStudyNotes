package com.waibizi.observer;

/**
 * @Author 歪鼻子
 * @Date 2020/7/14 0:02
 * @Description:
 * @Version 1.0
 */
public interface Observer {
    void update(float temperature, float pressure, float humidity);
}
