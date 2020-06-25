package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/23 21:14
 * @Description:
 * @Version 1.0
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {7,6,4,7,8,9,10,11,1};
        int maxIndex = 0;
        for (int end = array.length; end>0; end--){
            for (int begin = 1;begin<end;begin++){
                if (array[maxIndex]<array[begin]){
                    maxIndex = begin;
                }
            }
            int tmp = array[end-1];
            array[end-1] = array[maxIndex];
            array[maxIndex] = tmp;
        }
    }
}
