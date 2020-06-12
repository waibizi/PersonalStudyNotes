package com.waibizi.demo02;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 8:55
 * @Description:
 * @Version 1.0
 */
public class ComCover implements AutoInsurance{
    private String description;

    public String getInfo(){
        description = "Comprehensive Coverage: \n\nPays for damage to or loss of your "+
                "car in the event of fire, theft or "+
                "vandalism. Again, your lender may "+
                "require this coverage if your car is financed.";
        return description;
    }
}
