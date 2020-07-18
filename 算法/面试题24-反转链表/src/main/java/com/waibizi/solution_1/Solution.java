package com.waibizi.solution_1;

/**
 * @Author 歪鼻子
 * @Date 2020/7/16 18:55
 * @Description:
 * @Version 1.0
 */
class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead =  reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
