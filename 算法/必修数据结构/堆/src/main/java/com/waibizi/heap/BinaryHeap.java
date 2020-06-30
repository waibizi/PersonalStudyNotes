package com.waibizi.heap;
import com.waibizi.utils.BinaryTreeInfo;

import java.util.Comparator;
/**
 * @Author 歪鼻子
 * @Date 2020/6/23 23:10
 * @Description: 二叉堆，[最大堆][最小堆]: 默认是大顶堆
 * @Version 1.0
 */
public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    public BinaryHeap(E[] elements,Comparator<E> comparator) {
        super(comparator);
        if (elements == null || elements.length == 0){
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        }else{
            /* 创建一个乱堆，不要直接指向，Java直接指向是指向地址 */
            size = elements.length;
            int capacity = Math.max(elements.length,DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0;i <  elements.length; i++){
                this.elements[i]  = elements[i];
            }
            heapify();
        }
    }
    public BinaryHeap(E[] elements) {
        this(elements,null);
    }
    public BinaryHeap() {
        this(null, null);
    }

    private void heapify(){
        /* 自上而下的上滤 */
        for (int i = 1; i < size; i++){
            siftUp(i);
        }
        /* 自下而上的下滤 */
        for (int i = (size >> 1) ;i >= 0; i++){
            siftDown(i);
        }
    }
    @Override
    public void clear() {
        for (int i = 0; i < size ; i++){
            elements[i] = null;
        }
        size = 0;
    }
    /**
     * 思路：
     *    1.应该先检查添加的元素是否为空
     *    2.然后被添加之前应该先扩容存储的大小（或者说应该保证有位置可存储）
     *    3.被添加的元素可能不符合大顶堆（或者是小顶堆）的要求。所以添加完成之后应该要维护堆结构（也就是上滤）
     * @param element 添加的元素
     */
    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size+1);

        elements[size++] = element;
        siftUp(size-1);
    }
    @Override
    public E get() {
        /* 先检测堆是否为空 */
        emptyCheck();
        return elements[0];
    }
    @Override
    public E remove() {
        emptyCheck();
        /* 此处有坑，要进行先赋值再减减操作 */
        int lastIndex = --size;
        E root = elements[0];
        elements[0] = elements[lastIndex];

        elements[lastIndex] = null;
        siftDown(0);
        return root;
    }
    /**
     *
     * @param index 下滤索引位置
     */
    private void siftDown(int index){
        E element = elements[index];
        int half = size >> 1;
        /* 叶子节点个数是（n+1）/2  非叶子节点的个数是n/2 */
        while (index < half){
            /* index有两种情况，有一类只有左子节点，有一类有左又有右子节点 */
            /* 默认为左子节点跟它进行比较 */
            int childIndex = (index << 1)+1;
            E child = elements[childIndex];
            /* 右子节点 */
            int rightIndex = childIndex + 1;
            /* 选出左右子节点最大的那一个 */
            if (rightIndex < size && compare(elements[rightIndex],child) > 0){
                child = elements[childIndex = rightIndex];
            }

            if (compare(element,child) >= 0) break;
            /* 将子节点存放到index位置 */
            elements[index] = child;
            /* 重新设置index */
            index = childIndex;
        }
        elements[index] =  element;
    }

    /**
     * 直接将堆顶元素覆盖掉，然后进行下滤操作
     * @param element 替换的元素
     * @return
     */
    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0){
            elements[0] = element;
            size++;
        }else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }
        return root;
    }

    private void emptyCheck(){
        if (size == 0){
            throw new IndexOutOfBoundsException("Heap is empty");
        }
    }
    private void elementNotNullCheck(E element){
        if (element == null){
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
    /**
     * 上滤指定的索引位置到元素本应该在的位置
     * @param index 缩印下标
     */
    private void siftUp(int index){
//        未优化之前的代码
//        E e = elements[index];
//        while (index > 0){
//            int pindex = (index-1)>>1;
//            E p = elements[pindex];
//            if (compare(e, p) <= 0) return;
//            /* 交换p,e */
//            E tmp = elements[index];
//            elements[index] = elements[pindex];
//            elements[pindex] = tmp;
//            /* 因为更换了index与pindex了，此时的index在之前的pindex位置 */
//            index = pindex;
//        }
        /* 先不进行交换，直到最后再进行交换 */
        E element = elements[index];
        while (index > 0){
            int pindex = (index-1) >> 1;
            E pelement = elements[pindex];
            if (compare(element,pelement) <= 0) break;
            /* 将父元素存储在index位置 */
            elements[index] = pelement;
            /* 重新赋值index */
            index = pindex;
        }
        elements[index] = element;
    }

    @Override
    public Object root() {
        return 0;
    }
    @Override
    public Object left(Object node) {
        Integer index = (Integer)node;
        index = (index << 1) + 1;
        return index >= size ? null: index;
    }
    @Override
    public Object right(Object node) {
        Integer index = (Integer)node;
        index = (index << 1)+2;
        return index >= size ? null : index;
    }
    @Override
    public Object string(Object node) {
        Integer index = (Integer) node;
        return elements[index];
    }
}
