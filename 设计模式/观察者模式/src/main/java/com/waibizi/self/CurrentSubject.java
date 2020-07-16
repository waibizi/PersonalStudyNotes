package com.waibizi.self;

import java.util.ArrayList;

/**
 * @Author 歪鼻子
 * @Date 2020/7/14 1:23
 * @Description: 学生组织
 * @Version 1.0
 */
public class CurrentSubject implements Subject{
    private String name;
    private ArrayList<Observer> observers;
    public CurrentSubject() {
        observers = new ArrayList<Observer>();
    }
    /* 有哪个老师来巡查了，把老师名字报上 */
    public void setName(String name){
        this.name = name;
        hasDangerous();
    }
    /* 有危险，赶紧通知 */
    public void hasDangerous(){
        notifyObservers();
    }
    /* 观察者需要像学生组织报备 */
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    /* 移除观察者 */
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }
    /* 通知观察者 */
    public void notifyObservers() {
        for (Observer o:
             observers) {
            o.update(this.name);
        }
    }
}
