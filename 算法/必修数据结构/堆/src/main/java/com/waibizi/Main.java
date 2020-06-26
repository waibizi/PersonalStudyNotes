package com.waibizi;

import com.waibizi.heap.BinaryHeap;
import com.waibizi.utils.BinaryTrees;

/**
 * @Author 歪鼻子
 * @Date 2020/6/25 17:22
 * @Description:
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        /* 测试数据：72,68,50,43,38 */
        BinaryHeap<Integer> heap = new BinaryHeap<>();
        heap.add(50);
        heap.add(72);
        heap.add(38);
        heap.add(68);
        heap.add(43);
        BinaryTrees.println(heap);
    }
}
