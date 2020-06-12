package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 8:45
 * @Description:
 * @Version 1.0
 */

public class BodyPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
        return new BodyInjur();
    }
}