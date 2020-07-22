package com.waibizi.list;

/**
 * @Author 歪鼻子
 * @Date 2020/7/22 1:51
 * @Description:
 * @Version 1.0
 */
public class ArrayList<E> extends AbstractList<E> {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    public  ArrayList(int capacity){
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }
    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }
    @Override
    public void clear() {
        for (int i = 0; i < size; i++){
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }
    /**
     * 将index的值修改为传入的值
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }
    /**
     * 在index位置添加一个元素
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        /* 如果说容量是最后一个了，我们应该提前进行扩容 */
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = elements[index];
        for (int i = index+1; i < size; i++){
            elements[i-1] = elements[i];
        }
        elements[--size] = null;
        return oldElement;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){
            for (int i = 0; i < size; i++){
                if (element == null){
                    return i;
                }
            }
        }else{
            for (int i =0; i < size; i++){
                if (element == elements[i]){
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }
    /**
     * 保证要有capacity的容量,动态数组的扩容机制
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        /* 1.5的扩容机制 */
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++){
            newElements[i] = elements[i];
        }
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
