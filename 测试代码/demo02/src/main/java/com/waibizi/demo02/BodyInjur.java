package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 8:45
 * @Description:
 * @Version 1.0
 */
public class BodyInjur implements AutoInsurance {
    private String description;

    public String getInfo() {
        description = " Body Injur Liability: \n\nBodily injury coverage pays for medical bills" +
                " lost wages, rehabilitation, treatment and/or" +
                " funeral costs for anyone injured or killed " +
                " by your car. Such coverage will also pay for" +
                " pain and suffering damages when a third " +
                " party successfully sues. ";
        return description;
    }
}
