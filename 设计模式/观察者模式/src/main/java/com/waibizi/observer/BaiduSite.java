package com.waibizi.observer;

/**
 * @Author 歪鼻子
 * @Date 2020/7/14 0:23
 * @Description:
 * @Version 1.0
 */
public class BaiduSite implements Observer{
    /* 温度 */
    private float temperature;
    /* 气压 */
    private float pressure;
    /* 湿度 */
    private float humidity;

    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
    public void display(){
        System.out.println("==百度网站==");
        System.out.println("百度网站 气温"+temperature);
        System.out.println("百度网站 气压"+pressure);
        System.out.println("百度网站 湿度"+humidity);
    }
}
