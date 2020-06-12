package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 8:59
 * @Description:
 * @Version 1.0
 */

public class LuxuryCarInsurance implements AutoInsurance{
    private String description;

    @Override
    public String getInfo() {
        description = "吴典秋 201724113144LuxuryCarInsurance \n\nPays medical expense and some percentage of lost wages to you"+
                        "or anyone authorized to drive your car anyone authorized to drive your car,no matter who " +
                        "caused the accident.";
        return description;
    }
}
