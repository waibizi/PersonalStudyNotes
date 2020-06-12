package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 8:44
 * @Description:
 * @Version 1.0
 */

public class Property implements AutoInsurance {
    private String description;

    public String getInfo() {
        description = "Property-Damage Liability Coverage: "+
                "This coverage pays for the repair "+
                "and replacement of vehicles and "+
                "other property damaged when you "+
                "or another authorized driver  "+
                "causes an accident";
        return description;
    }
}
