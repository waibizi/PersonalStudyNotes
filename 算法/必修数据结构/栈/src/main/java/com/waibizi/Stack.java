package com.waibizi;

import com.waibizi.list.AbstractList;
import com.waibizi.list.ArrayList;
import com.waibizi.list.List;

/**
 * @Author 歪鼻子
 * @Date 2020/7/22 2:27
 * @Description:
 * @Version 1.0
 */
public class Stack<E> {
    private List<E> list = new ArrayList<>();
    public void clear(){
        list.clear();
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void push(E element){
        list.add(element);
    }
    public E pop(){
        return list.remove(list.size()-1);
    }
    public E peek(){
        return list.get(list.size()-1);
    }
}
