package com.waibizi.Solution_1;

/**
 * @Author 歪鼻子
 * @Date 2020/6/12 11:47
 * @Description:
 * @Version 1.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        if (prices.length == 0)
            return result;
        int max = prices[prices.length-1];
        for (int i = prices.length-1;i>=0;i--){
            if (max<prices[i])
                max = prices[i];
            if ((max-prices[i])>result)
                result = max - prices[i];
        }
        return result;
    }
}
