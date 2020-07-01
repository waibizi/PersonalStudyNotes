package com.waibizi.dynamic;

/**
 * @Author 歪鼻子
 * @Date 2020/6/30 17:09
 * @Description:
 * @Version 1.0
 */
public interface Array<E> {
    /* 元素数量 */
    int size();
    /* 是否为空 */
    boolean isEmpty();
    /* 是否包含某个元素 */
    boolean contains(E element);
    /* 添加元素到最后面, */
    void add(E element);
    /* 返回index位置对应的元素 */
    E get(int index);
    /* 设置index位置的元素 */
    E set(int index,E element);
    /* 往index位置添加元素 */
    void add(int index,E element);
    /* 删除index位置对应的元素，并且返回删除元素的值 */
    E remove(int index);
    /* 查看元素的位置 */
    int indexOf(E element);
    /* 清除所有元素 */
    void clear();
}
