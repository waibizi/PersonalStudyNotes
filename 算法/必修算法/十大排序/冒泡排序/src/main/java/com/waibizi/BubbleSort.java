package com.waibizi;

/**
 * @Author 歪鼻子
 * @Date 2020/6/23 17:22
 * @Description:
 * @Version 1.0
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {4,6,7,8,9,7,1,2,3,4};
        for (int out:
                array) {
            System.out.print(out+" ");
        }
        System.out.println();
        System.out.println("------------");
        for (int end = array.length; end>0; end--){
            for (int begin = 1;begin<end; begin++){
                if (array[begin] < array[begin-1]){
                    int tmp = array[begin];
                    array[begin] = array[begin-1];
                    array[begin-1] = tmp;
                }
            }
        }
        for (int out:
             array) {
            System.out.print(out+" ");
        }
    }
}
