package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 9:04
 * @Description:
 * @Version 1.0
 */

public class LuxuryCarInsurancePolicy implements PolicyProducer{
    @Override
    public AutoInsurance getInsurObj() {
        return new LuxuryCarInsurance();
    }
}
