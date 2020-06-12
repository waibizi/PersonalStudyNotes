package com.waibizi.C64;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/21 2:15
 */
public class Employee implements Cloneable{

    public Employee clone() throws CloneNotSupportedException
    {
        return (Employee)super.clone();
    }
}
