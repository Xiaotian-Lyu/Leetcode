package linkedlist;

import model.ListNode;

public class Q206 {
    public static ListNode reverseLinked(ListNode head) {
       ListNode cur = head;
       ListNode pre = null;
       while(cur != null){
           ListNode next = cur.next;
           cur.next = pre;
           pre = cur;
           cur = next;
       }
       return pre;
    }

}
