package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/23 17:42
 * @Description: 传统的冒泡排序如果原本数组有序的情况下，还要进行两轮的比较，浪费时间，可以改进
 * @Version 1.0
 */
public class BubbleSortPro {
    public static void main(String[] args) {
        int[] array = {7,3,4,1,2,9,8,10,15};
        for (int out:
                array) {
            System.out.print(out+" ");
        }
        System.out.println();
        System.out.println("------------");
        for (int end = array.length; end>0; end--){
            boolean sorted = true;
            for (int begin=1; begin<end; begin++){
                if (array[begin]<array[begin-1]){
                    int tmp = array[begin];
                    array[begin] = array[begin-1];
                    array[begin-1] = tmp;
                    sorted = false;
                }
            }
            if (sorted) break;
        }
        for (int out:
                array) {
            System.out.print(out+" ");
        }
    }
}
