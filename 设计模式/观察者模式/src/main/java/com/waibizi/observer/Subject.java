package com.waibizi.observer;

/**
 * @Author 歪鼻子
 * @Date 2020/7/13 22:55
 * @Description:
 * @Version 1.0
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
