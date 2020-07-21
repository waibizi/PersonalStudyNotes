package com.waibizi.双向链表;

/**
 * @Author 歪鼻子
 * @Date 2020/7/11 17:14
 * @Description:
 * @Version 1.0
 */
public abstract class AbstractList<E> implements List<E> {
    /**
     * 元素的数量
     */
    protected int size;
    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return size;
    }
    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){

        return size == 0;
    }
    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }
    /**
     * 往尾部添加元素
     * @param element
     */
    public void add(E element){
        add(size,element);
    }
    protected void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index:"+index+", Size:"+size);
    }
    protected void rangeCheck(int index){
        if (index < 0 || index >= size){
            outOfBounds(index);
        }
    }
    protected void rangeCheckForAdd(int index){
        if (index < 0 || index > size){
            outOfBounds(index);
        }
    }
}
