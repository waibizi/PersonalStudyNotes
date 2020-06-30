package com.waibizi.heap;

import java.util.Comparator;

/**
 * @Author 歪鼻子
 * @Date 2020/6/25 21:31
 * @Description:
 * @Version 1.0
 */
@SuppressWarnings(value = "All")
public abstract class AbstractHeap <E> implements Heap<E>{
    protected int size;   //堆的实际大小
    protected Comparator<E> comparator;
    public AbstractHeap(Comparator<E> comparator) {
        this.comparator = comparator;
    }
    public AbstractHeap() {
        this(null);
    }

    protected int compare(E e1, E e2){
        return comparator != null ? comparator.compare(e1,e2) : ((Comparable<E>) e1).compareTo(e2);
    }
    @Override
    public int size() {
        return 0;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

}
