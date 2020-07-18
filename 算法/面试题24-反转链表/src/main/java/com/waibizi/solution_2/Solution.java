package com.waibizi.solution_2;

/**
 * @Author 歪鼻子
 * @Date 2020/7/18 15:03
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
        ListNode newNode = null;
        ListNode temp = null;
        while (head != null){
            temp = head.next;
            head.next = newNode;
            newNode = head;
            head = temp;
        }
        return newNode;
    }
}
