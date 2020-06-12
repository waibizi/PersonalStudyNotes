package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 8:45
 * @Description:
 * @Version 1.0
 */

public class Collision implements AutoInsurance {
    private String description;

    public String getInfo(){
        description = "Collision Coverage: \n\nPays for damage to your car, less "+
                "any deductible, no matter who is at "+
                "fault. If your car is financed, your "+
                "lender may require you to buy this coverage "+
                "and may even require a particular deductible amount.";
        return description;
    }
}