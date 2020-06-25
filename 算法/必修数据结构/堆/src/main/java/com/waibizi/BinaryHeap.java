package com.waibizi;

import java.util.Comparator;

/**
 * @Author 歪鼻子
 * @Date 2020/6/23 23:10
 * @Description: 二叉堆，[最大堆][最小堆]: 默认是大顶堆
 * @Version 1.0
 */
public class BinaryHeap<E> implements Heap<E>{
    private E[] elements;
    private int size;   //堆的实际大小
    private Comparator<E> comparator;
    private static final int DEFAULT_CAPACITY = 10;
    public BinaryHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.elements = (E[])new Object[DEFAULT_CAPACITY];
    }
    public BinaryHeap() {
        this(null);
    }
    @Override
    public int size() {
        return 0;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void clear() {
        for (int i = 0; i < size ; i++){
            elements[i] = null;
        }
        size = 0;
    }
    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size+1);
        elements[size++] = element;
    }
    @Override
    public E get() {
        /*先检测堆是否为空*/
        emptyCheck();
        return elements[0];
    }
    @Override
    public E remove() {
        return null;
    }
    @Override
    public E replace(E element) {
        return null;
    }
    private int compare(E e1,E e2){
        return comparator != null ? comparator.compare(e1,e2) : ((Comparable<E>) e1).compareTo(e2);
    }
    private void emptyCheck(){
        if (size == 0){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }
    private void elementNotNullCheck(E element){
        if (size == 0){
            throw new IllegalArgumentException("element must not be null");
        }
    }
    private void ensureCapacity(int capacity){
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        /*新容量为旧容量的1.5倍*/
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        /* 创建一个新的数组 */
        E[] newElements = (E[]) new Object[newCapacity];
        /* 数据迁移 */
        for (int i = 0;i<size;i++){
            newElements[i] = elements[i];
        }
        /* 更换堆中的实际存储 */
        elements = newElements;
    }
}
