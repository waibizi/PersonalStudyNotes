package com.waibizi.observer;

import java.util.ArrayList;

/**
 * @Author 歪鼻子
 * @Date 2020/7/14 0:58
 * @Description:
 * @Version 1.0
 */
public class WeatherData implements Subject{
    private float temperatrue;
    private float pressure;
    private float humidity;
    /* 观察者集合 */
    private ArrayList<Observer> observers;
    public WeatherData() {
        observers = new ArrayList<Observer>();
    }
    public void dataChange() {
        //调用 接入方的 update
        notifyObservers();
    }
    //当数据有更新时，就调用 setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperatrue = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        //调用dataChange， 将最新的信息 推送给 接入方 currentConditions
        dataChange();
    }
    public void registerObserver(Observer o) {
        observers.add(o);
    }
    /* 移除观察者 */
    public void removeObserver(Observer o) {
        if(observers.contains(o)) {
            observers.remove(o);
        }
    }
    /* 遍历所有的观察者，并通知 */
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
        }
    }

}
