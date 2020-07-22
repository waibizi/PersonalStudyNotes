package com.waibizi.双向链表;

/**
 * @Author 歪鼻子
 * @Date 2020/7/11 17:13
 * @Description:
 * @Version 1.0
 */
public class LinkedList<E> extends AbstractList<E>{
    private Node<E> first;
    private Node<E> last;
    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> node = node(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        /* 往最后添加元素 */
        if (index == size){
            Node<E> oldLast = last;
            last = new Node<>(oldLast,element,null);
            /*  如果这个是当前链表添加的第一个元素 */
            if (oldLast == null){
                first = last;
            }else {
                oldLast.next = last;
            }
        }else {
            Node<E> next = node(index);
            Node<E> pre = next.pre;
            Node<E> node = new Node<>(pre,element,next);
            next.pre = node;
            /* index == 0 */
            if (pre == null){
                first = node;
            }else{
                pre.next = node;
            }
        }
        size++;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        Node<E> pre = node.pre;
        Node<E> next = node.next;
        /* index = 0的情况 */
        if (pre == null){
            first = next;
        }else{
            pre.next = next;
        }
        size--;
        return node.element;
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

    private Node<E> node(int index){
        rangeCheck(index);
        if (index < (size >> 1)){
            Node<E> node = first;
            for (int i = 0; i < index; i++){
                node = node.next;
            }
            return node;
        }else{
            Node<E> node = last;
            for (int i = size -1; i > index; i--){
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
