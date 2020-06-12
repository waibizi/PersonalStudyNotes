package Solution_1;

/**
 * @Author 歪鼻子
 * @Date 2020/6/12 16:23
 * @Description:
 * @Version 1.0
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode temp = newList;

        while (l1 != null && l2 != null){
            if (l1.val >= l2.val){
                temp = l2;
                temp = temp.next;
                temp = l1;
            }else {
                temp = l1;
                temp = temp.next;
                temp = l2;
            }
            temp = temp.next;
            l1 = l1.next; l2 = l2.next;
        }
        return newList;
    }
}
