package linkedlist;

import model.ListNode;

public class Q206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;//把最后会变成末尾的node指向null
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;//next always next to the cur
            cur.next = pre;//change the next
            pre = cur;//update the pre and cur
            cur = next;
        }
        return pre;//最后一步是cur = null , the new head will be pre;
    }

}
