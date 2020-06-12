package com.waibizi.demo03;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 9:19
 * @Description:
 * @Version 1.0
 */


public class MediumBuildingFactory extends BuildingFactory {

    public House getHouse(){
        return new MediumHouse();
    }

    public Condo getCondo(){
        return new MediumCondo();
    }

    public SemiDetacher getSemiDetacher() { return new MediumSemiDetacher(); }
}
