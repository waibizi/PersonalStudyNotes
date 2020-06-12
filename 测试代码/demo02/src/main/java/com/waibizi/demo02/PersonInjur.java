package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 8:46
 * @Description:
 * @Version 1.0
 */
public class PersonInjur implements AutoInsurance {
    private String description;

    public String getInfo() {
        description = "Personal Injury Protection \n\nPays medical expenses and some percentage "+
                "of lost wages to you or anyone authorized "+
                "to drive your car, no matter who caused the accident.";
        return description;
    }
}
