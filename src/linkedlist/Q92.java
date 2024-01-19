package linkedlist;

import model.ListNode;

public class Q92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || left == right){
            return head;
        }

        //a dummy listNode
        ListNode dummy = new ListNode();
        dummy.next = head;

        //define pre ListNode
        ListNode pre = dummy;

        for(int i = 1; i <= left - 1; i++){//the pre go to the pre reverse place
            pre = pre.next;
        }

        //after know the pre can know the cur and future listNode
        ListNode cur = pre.next;//错误写法cur = dummy.next;dummy不能动！！
        ListNode future = cur.next;

        for(int i = 1; i <= right - left ; i++){//count the time need to convert
            cur.next = future.next;
            future.next = pre.next;//cur but cur will be change pre.next won't
            pre.next = future;
            future = cur.next;//update the future
        }

        return dummy.next;
    }
}
