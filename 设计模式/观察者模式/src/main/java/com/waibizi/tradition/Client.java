package com.waibizi.tradition;

/**
 * @Author 歪鼻子
 * @Date 2020/7/13 17:10
 * @Description:
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        CurrentConditions currentConditions = new CurrentConditions();
        WeatherData weatherData = new WeatherData(currentConditions);
        weatherData.setData(30,150,40);
    }
}
