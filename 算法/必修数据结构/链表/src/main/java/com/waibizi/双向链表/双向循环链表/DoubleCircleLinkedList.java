package com.waibizi.双向链表.双向循环链表;

import com.waibizi.双向链表.AbstractList;
import com.waibizi.双向链表.Node;

/**
 * @Author 歪鼻子
 * @Date 2020/7/20 21:25
 * @Description:
 * @Version 1.0
 */
public class DoubleCircleLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    /**
     * 双向循环链表的添加的时候，循环注意在头部与尾部对接的时候
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        /* 如果说Index的值等于size的话，也就是往链表的最后添加元素 */
        if (index == size){
            Node<E> oldLast = last;
            last = new Node<>(oldLast,element,first);
            if (oldLast == null){
                first = last;
                first.pre = first;
                first.next = first;
            }else{
                oldLast.next = last;
                first.pre = last;
            }
        }else{
             Node<E> next = node(index);
             Node<E> pre = next.pre;
             Node<E> newNode = new Node<>(pre,element,next);
             next.pre = newNode;
             pre.next = newNode;
             if (next == first){
                 first = newNode;
             }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> rmNode = node(index);
        if (size == 1){
            first = null;
            last = null;
        }else{
            Node<E> pre = rmNode.pre;
            Node<E> next = rmNode.next;
            /* 跳跃过去中间的部分 */
            next.pre = pre;
            pre.next = next;
            /*  对于链表的头部与尾部需要做处理 */
            if (rmNode == first){
                first = next;
            }
            if (rmNode == last){
                last = pre;
            }
        }
        size--;
        return rmNode.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null){
            Node<E> node = first;
            for (int i = 0; i < size; i++){
                if (node.element == null) return i;
                node = node.next;
            }
        }else {
            Node<E> node = first;
            for (int i = 0; i<size; i++){
                if (node.element == element) return i;
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        if (index < (size >> 1)) {
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("size = ").append(size).append(",【");
        Node<E> node = first;
        for (int i = 0; i < size; i++){
            if (i != 0){
                sb.append(", ");
            }
            sb.append(node);
            node = node.next;
        }
        sb.append("】");
        return sb.toString();
    }
}
