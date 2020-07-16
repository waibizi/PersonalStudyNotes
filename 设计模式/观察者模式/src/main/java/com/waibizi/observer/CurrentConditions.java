package com.waibizi.observer;

/**
 * @Author 歪鼻子
 * @Date 2020/7/14 0:05
 * @Description:
 * @Version 1.0
 */
public class CurrentConditions implements Observer{
    /* 温度 */
    private float temperature;
    /* 气压 */
    private float pressure;
    /* 湿度 */
    private float humidity;

    /* 更新天气的情况，由WeatherData来调用，采用推送模式 */
    public void update(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
    /* 显示 */
    public void display(){
        System.out.println("今天的气温是"+temperature);
        System.out.println("今天的气压是"+pressure);
        System.out.println("今天的湿度"+humidity);
    }
}
