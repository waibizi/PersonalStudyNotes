package com.waibizi.List;

/**
 * 自定义List接口
 * @author 歪鼻子
 * @version 1.0
 * @date 2020/4/23 22:02
 */
public interface List<E> {
    void add(E object);

    void add(int index, E object);

    Object remove(int index);

    boolean remove(E object);

    int getSize();

    Object get(int index);
}
