package com.waibizi.Solution_1;

/**
 * @Author 歪鼻子
 * @Date 2020/6/12 16:05
 * @Description: 此题有点小坑，这个题的头是存储值得到，如果说头的值已经是要删除的，那么直接把头放弃掉，直接返回就可以了
 *               如果说删除的是后续的节点，那么都是正常情况，唯一需要考虑的就是尾结点是不是也是能够采用中间的删除操作进行的
 * @Version 1.0
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = head;
        if (head.val == val) {
            pre =head.next;
            return pre;
        }
        ListNode node = head.next;

        if (node ==null) return head;
        while (node.val != val && node.next != null){
            node = node.next;
            pre = pre.next;
        }
        pre.next = node.next;
        return head;
    }
}
