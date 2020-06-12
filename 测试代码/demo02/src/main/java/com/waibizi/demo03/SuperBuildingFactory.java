package com.waibizi.demo03;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 9:20
 * @Description:
 * @Version 1.0
 */

public class SuperBuildingFactory extends BuildingFactory {

    public House getHouse(){
        return new SuperHouse();
    }

    public Condo getCondo(){
        return new SuperCondo();
    }


    public SemiDetacher getSemiDetacher(){
        return new SuperSemiDetacher();
    }
}
