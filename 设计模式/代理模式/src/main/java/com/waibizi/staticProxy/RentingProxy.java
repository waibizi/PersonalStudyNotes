package com.waibizi.staticProxy;

/**
 * @Author 歪鼻子
 * @Date 2020/5/30 0:20
 * @Description:
 * @Version 1.0
 */

public class RentingProxy implements IRenting{

    /**
     * 代理对象，通过接口来聚合
     */
    private IRenting target;

    public RentingProxy(IRenting target) {
        this.target = target;
    }

    @Override
    public void rent() {
        System.out.println("代理开始");
        target.rent();
        System.out.println("代理结束");
    }
}
