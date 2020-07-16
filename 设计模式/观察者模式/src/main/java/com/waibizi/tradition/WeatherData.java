package com.waibizi.tradition;
/**
 * @Author 歪鼻子
 * @Date 2020/7/13 16:12
 * @Description: 包含最新的天气情况、含有CurrentConditions对象
 *               当数据有更新的时候，就主动调用CurrentConditions对象的update方法
 * @Version 1.0
 */
public class WeatherData {
    /* 温度 */
    private float temperature;
    /* 气压 */
    private float pressure;
    /* 湿度 */
    private float humidity;
    private CurrentConditions currentConditions;
    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
    }
    public float getTemperature() {
        return temperature;
    }
    public float getPressure() {
        return pressure;
    }
    public float getHumidity() {
        return humidity;
    }
    public void dataChange(){
        currentConditions.update(getTemperature(),getPressure(),getHumidity());
    }
    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        dataChange();
    }
}
