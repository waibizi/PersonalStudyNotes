package com.waibizi.C62;

import com.waibizi.List.ArrayList;

import java.util.List;

/**
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/20 15:35
 */
public class Emplyee implements Comparable<Emplyee>{

    private String name;
    private double salary;

    public Emplyee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public double getSalary() {
        return salary;
    }




    @Override
    public int compareTo(Emplyee o) {
        return Double.compare(salary,o.salary);
    }
}
