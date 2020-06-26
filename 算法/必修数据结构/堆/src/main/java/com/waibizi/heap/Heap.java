package com.waibizi.heap;

/**
 * @Author 歪鼻子
 * @Date 2020/6/23 23:11
 * @Description:
 * @Version 1.0
 */
public interface Heap<E> {
    /* 获取堆中的元素数量 */
    int size();
    /* 判断堆是否为空 */
    boolean isEmpty();
    /* 清空堆 */
    void clear();
    void add(E element);
    /* 获取堆顶元素 */
    E get();
    /* 删除堆顶元素并返回堆顶元素 */
    E remove();
    /* 删除堆顶元素的同时插入一个新元素，同时还是返回被删除的元素 */
    E replace(E element);

}
