package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/23 18:07
 * @Description: 如果后续是有序的话，可以直接让后续的有序数组去除掉
 * @Version 1.0
 */
public class BubbleSortProPro {
    public static void main(String[] args) {
        int[] array = {7,3,4,1,2,9,8,10,1,99};
        for (int out:
                array) {
            System.out.print(out+" ");
        }
        System.out.println();
        System.out.println("------------");
        int mark = 0;
        for (int end = array.length; end>0; end--){
            for (int begin=1; begin<end; begin++){
                if (array[begin]<array[begin-1]){
                    int tmp = array[begin];
                    array[begin] = array[begin-1];
                    array[begin-1] = tmp;
                    mark = begin;
                }
            }
            end = mark;
        }
        for (int out:
                array) {
            System.out.print(out+" ");
        }
    }
}
