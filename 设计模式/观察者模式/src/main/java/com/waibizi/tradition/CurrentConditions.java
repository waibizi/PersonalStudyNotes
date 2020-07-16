package com.waibizi.tradition;

/**
 * @Author 歪鼻子
 * @Date 2020/7/13 16:04
 * @Description:
 * @Version 1.0
 */
public class CurrentConditions {
    /* 温度 */
    private float temperature;
    /* 气压 */
    private float pressure;
    /* 湿度 */
    private float humidity;
    /**
     * 更新数据
     * @param temperature 温度
     * @param pressure 气压
     * @param humidity 湿度
     */
    public void update(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("今天的温度是"+temperature+"摄氏度");
        System.out.println("今天的压强是"+pressure);
        System.out.println("今天的湿度是"+humidity);
    }
}
