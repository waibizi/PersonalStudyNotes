package com.waibizi.self;

/**
 * @Author 歪鼻子
 * @Date 2020/7/14 1:50
 * @Description:
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        CurrentSubject subject = new CurrentSubject();
        AObserver aObserver = new AObserver();
        BObserver bObserver = new BObserver();
        subject.registerObserver(aObserver);
        subject.registerObserver(bObserver);
        subject.setName("歪鼻子");
    }
}
