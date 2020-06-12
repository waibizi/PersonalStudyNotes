package com.waibizi.demo03;

/**
 * @Author 吴典秋
 * @Date 2020/5/26 9:18
 * @Description:
 * @Version 1.0
 */

public abstract class BuildingFactory{
    public static final String SUPER = "Super Class";
    public static final String MEDIUM = "Medium Class";

    public abstract House getHouse();
    public abstract Condo getCondo();
    public abstract SemiDetacher getSemiDetacher();

    public static BuildingFactory getBuildingFactory(String type){
        BuildingFactory bf = null;

        if (type.equals(BuildingFactory.SUPER)){
            bf = new SuperBuildingFactory();
        }
        else if (type.equals(BuildingFactory.MEDIUM)){
            bf = new MediumBuildingFactory();
        }

        return bf;
    }
}
