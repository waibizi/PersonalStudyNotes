package com.waibizi;

import com.waibizi.heap.BinaryHeap;
import com.waibizi.utils.BinaryTrees;

import java.util.Comparator;

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
        heap.remove();
        BinaryTrees.println(heap);
        heap.replace(70);
        BinaryTrees.println(heap);
    }
    static void test3() {
        Integer[] data = {88, 44, 53, 41, 16, 6, 70, 18, 85, 98, 81, 23, 36, 43, 37};
        BinaryHeap<Integer> heap = new BinaryHeap<>(data, (o1, o2) -> o2 - o1);
        BinaryTrees.println(heap);
    }
}
