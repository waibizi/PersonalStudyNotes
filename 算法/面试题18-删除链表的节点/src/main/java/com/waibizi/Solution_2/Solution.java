package com.waibizi.Solution_2;

/**
 * @Author 歪鼻子
 * @Date 2020/7/16 17:42
 * @Description:
 * @Version 1.0
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode node = head;
        while (node.val != val){
            node = node.next;
        }
        if (node.next == null){
            node = null;
            return head;
        }
        node.val = node.next.val;
        node.next = node.next.next;
        return head;
    }
}
