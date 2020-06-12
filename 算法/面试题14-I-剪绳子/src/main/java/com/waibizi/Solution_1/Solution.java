package com.waibizi.Solution_1;

/**
 * @Author 歪鼻子
 * @Date 2020/6/12 15:35
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) return n-1;
        int a = n/3 , b = n%3;
        if (b == 0) return (int)Math.pow(3 , a);
        if (b == 1) return (int)Math.pow(3 , a-1)*4;
        return (int)Math.pow(3 , a)*2;
    }
}
