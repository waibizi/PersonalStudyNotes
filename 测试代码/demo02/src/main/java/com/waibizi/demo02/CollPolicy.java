package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 8:44
 * @Description:
 * @Version 1.0
 */
public class CollPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
        return new Collision();
    }
}
