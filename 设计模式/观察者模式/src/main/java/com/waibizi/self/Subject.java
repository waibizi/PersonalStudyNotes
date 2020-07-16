package com.waibizi.self;


/**
 * @Author 歪鼻子
 * @Date 2020/7/14 1:19
 * @Description:
 * @Version 1.0
 */
public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
