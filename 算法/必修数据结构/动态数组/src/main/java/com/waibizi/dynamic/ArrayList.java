package com.waibizi.dynamic;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Arrays;

/**
 * @Author 歪鼻子
 * @Date 2020/6/30 17:04
 * @Description:
 * @Version 1.0
 */
public class ArrayList<E> implements Array<E> {
    /* 数组元素的数量 */
    private int size;
    /* 存放的数组 */
    private E[] elements;
    /* 默认容量 */
    private static final int DEFAULT_CAPACITY = 10;
    /* 找不到元素标记 */
    private static final int ELEMENT_NOT_FOUND = -1;
    public ArrayList(int capacity){
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }
    /**
     * @return 返回数组元素实际数量
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * @return 返回是否为空
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    @Override
    public void add(E element) {
        add(size,element);
    }
    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 在index指定位置添加元素
     * @param index 下标
     * @param element 元素
     * @return 返回袁磊位置的值
     */
    @Override
    public E set(int index, E element) {
        /* 涉及到index的都要检查index */
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }
    /**
     *  往指定位置添加元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }
    @Override
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];
        for (int i = index+1; i < size; i++){
            elements[i-1] = elements[i];
        }
        elements[--size] = null;
        return old;
    }
    public E remove(E element){
        int index = indexOf(element);
        return  remove(index);

    }
    /**
     * @param element 传入元素
     * @return 返回传入元素的下标
     */
    @Override
    public int indexOf(E element) {
        if (element == null){
            for (int i = 0; i < size; i++){
                if (elements[i] == null) return i;
            }
        }else {
            for (int i = 0; i < size; i++){
                if (element.equals(elements[i])) return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }
    /**
     * 清除所有的元素
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }
    /**
     * 数据扩容
     * @param capacity 需要的最低内存大小
     */
    private void ensureCapacity(int capacity){
        /* 先保存旧容量 */
        int oldCapacity = elements.length;
        /* 如果旧内存大于最低内存 */
        if (oldCapacity >= capacity) return;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("数组动态扩容，从"+oldCapacity+"扩容到"+newCapacity);
    }

    /**
     * 添加比较特殊，允许插入的位置是等于size的，所以不用检查size
     * @param index 检查下标
     */
    private void rangeCheckForAdd(int index){
        /* 数据添加位置不存在，抛出异常 */
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }
    /**
     * 这个检查下标是提供给get或者是remove操作的，因为size位置不存储值，所以应该判断等不等于size
     * @param index 下标
     */
    private void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }
    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index + ",Size:"+size);
    }
    @Override
    public String toString() {
        /* StringBuilder是JDK1.5之后添加的，这个是不安全的String拼接类，但是效率比较高，使用StringBuffer的话线程安全，但是效率不高 */
        StringBuilder string = new StringBuilder();
        string.append("size = ").append(size).append(",[");
        for (int i = 0; i < size; i++){
            if (i != 0){
                string.append(",");
            }
            string.append(elements[i]);
        }
        string.append("]");
        return string.toString();
    }
}
