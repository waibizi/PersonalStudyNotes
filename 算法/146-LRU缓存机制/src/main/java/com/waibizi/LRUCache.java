package com.waibizi;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 吴典秋
 * @Date 2020/6/8 22:36
 * @Description:
 * @Version 1.0
 */
class Node{
    int key,val;
    Node pre, next;
    public Node(int key,int val){
        this.key = key;
        this.val = val;
    }
}
class DoubleList{
    Node head,tail;
    int size;
    public DoubleList(){
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }
    public void addHead(Node node){
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
        size++;
    }
    public void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
        size--;
    }
    public Node removeTail(){
        if (tail.pre == head){
            return null;
        }
        Node last = tail.pre;
        remove(last);
        return last;
    }
    int size(){
        return size;
    }
}
public class LRUCache {
    int capacity;
    DoubleList cache;
    Map<Integer,Node> map;

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }
    public int get(int key){
        if (!map.containsKey(key)){
            return -1;
        }
        int value = map.get(key).val;
        put(key,value);
        return value;
    }
    public void put(int key,int value){
        Node node = new Node(key,value);
        if (map.containsKey(key)){
            cache.remove(map.get(key));
            cache.addHead(node);
            map.put(key,node);
        }else {
            if (map.size()==capacity){
                Node x = cache.removeTail();
                map.remove(x.key);
            }
            cache.addHead(node);
            map.put(key,node);
        }
    }
}


